package com.iyoumei.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class RewardCalculateException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RewardCalculateException(String msg)
    {
        super(msg);
    }

    public RewardCalculateException(String msg, Throwable ex)
    {
        super(msg);
        cause = ex;
    }

    @Override
	public Throwable getCause()
    {
        return cause != this ? cause : null;
    }

    @Override
	public String getMessage()
    {
        if(cause == null || cause == this)
            return super.getMessage();
        else
            return super.getMessage() + "; nested exception is " + cause.getClass().getName() + ": " + cause.getMessage();
    }

    @Override
	public void printStackTrace(PrintStream ps)
    {
        if(cause == null || cause == this)
        {
            super.printStackTrace(ps);
        } else
        {
            ps.println(this);
            cause.printStackTrace(ps);
        }
    }

    @Override
	public void printStackTrace(PrintWriter pw)
    {
        if(cause == null || cause == this)
        {
            super.printStackTrace(pw);
        } else
        {
            pw.println(this);
            cause.printStackTrace(pw);
        }
    }

    @SuppressWarnings("rawtypes")
	public boolean contains(Class exClass)
    {
        if(exClass == null)
            return false;
        for(Throwable ex = this; ex != null;)
        {
            if(exClass.isInstance(ex))
                return true;
            if(ex instanceof RewardCalculateException)
                ex = ((RewardCalculateException)ex).getCause();
            else
                ex = null;
        }

        return false;
    }

    private Throwable cause;
}
