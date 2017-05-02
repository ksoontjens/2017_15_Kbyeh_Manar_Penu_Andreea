/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class manager {

    static manager manger;
    HelloTVXlet view;
    
    public static manager getInstance()
    {
        if (manger==null) manger=new manager();
        return manger;
    }
    
    public HelloTVXlet getApplicationManager()
    {
        return view;
    }
    
    public void setApplicationManager(HelloTVXlet ap)
    {
        this.view=ap;
    }
    
}