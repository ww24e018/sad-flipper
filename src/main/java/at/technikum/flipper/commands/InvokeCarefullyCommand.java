package at.technikum.flipper.commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeCarefullyCommand implements Command {

    private boolean invokeIsPossible = false;
    private Class classToCastSenderTo;
    private Object target;
    private Object sender;
    private Class targetClazz;
    private final String methodName;

    /**
     * For now: no Object... otherwise what exactly will be downcast?
     * @param target
     * @param methodName
     * @param sender
     */
    public InvokeCarefullyCommand(Object target, String methodName, Object sender) {
        Class targetClazz =  target.getClass();
        Class senderClazz =  sender.getClass();

        this.methodName = methodName;
        this.target = target;
        this.sender = sender;

        this.targetClazz = targetClazz;

        while(!isThisInvokabe(targetClazz, methodName, senderClazz) && senderClazz != Object.class) {
            senderClazz = senderClazz.getSuperclass();
        }
    }

    @Override
    public void execute() {
        if (invokeIsPossible) {
            try {
                var method = this.targetClazz.getMethod(methodName, classToCastSenderTo);
                try {
                    method.invoke(target, new Object[]{classToCastSenderTo.cast(sender)});
                } catch (InvocationTargetException e) {
                    return; // should not happen?
                } catch (IllegalAccessException e) {
                    return; // this seems a thing that might happen I guess?
                }
            } catch (NoSuchMethodException e) {
                return; // should not happen, or should it?
            }
        }
    }

    private boolean isThisInvokabe(Class targetClazz, String methodName, Class senderClazz) {
        Method method;
        try {
            method = targetClazz.getMethod(methodName, senderClazz);
            invokeIsPossible = true;
            classToCastSenderTo = senderClazz;
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    };

}
