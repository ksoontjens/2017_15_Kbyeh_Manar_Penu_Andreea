/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class managergame {

    static managergame ik;
    HelloTVXlet ap;
    
    public static managergame getInstance()
    {
        if (ik==null) ik=new managergame();
        return ik;
    }
    
    public HelloTVXlet getApplicationManager()
    {
        return ap;
    }
    
    public void setApplicationManager(HelloTVXlet ap)
    {
        this.ap=ap;
    }
    
}

