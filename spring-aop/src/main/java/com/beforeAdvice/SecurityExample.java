package com.beforeAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String[] args) {
        // Get the security manager
        SecurityManager mgr = new SecurityManager();

        //get the bean
        SecureBean bean = getSecureBean();

        //try as clarence
        mgr.login("clarence","pwd");
        bean.writeSecureMessage();
        mgr.logout();

        //try as janm
        try{
            mgr.login("rony","pwd");
        }catch (SecurityException e){
            System.out.println("Exception Caught: "+ e.getMessage());
        }finally {
            mgr.logout();
        }

        //try with no credentials
        try{
            bean.writeSecureMessage();
        }catch(SecurityException e){
            System.out.println("Exception Caught: "+e.getMessage()
            );
        }
    }

    public static SecureBean getSecureBean(){
        //create the target
        SecureBean target = new SecureBean();

        //Create the advice
        SecurityAdvice advice = new SecurityAdvice();

        //get the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(advice);
        SecureBean proxy = (SecureBean)pf.getProxy();

        return proxy;
    }
}
