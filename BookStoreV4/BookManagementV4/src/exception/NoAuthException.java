package exception;
/**
 * �޲���Ȩ���쳣
 * @author Tricia
 * @version 4
 */
public class NoAuthException extends RuntimeException
{

	private static final long serialVersionUID = 4509683986113420187L;
    public NoAuthException() {
    	super();
    	System.out.println("û�в���Ȩ���쳣");
    }
    
    public NoAuthException(String message) {
    	super(message);
    }
}
