package exception;
/**
 * 无操作权限异常
 * @author Tricia
 * @version 4
 */
public class NoAuthException extends RuntimeException
{

	private static final long serialVersionUID = 4509683986113420187L;
    public NoAuthException() {
    	super();
    	System.out.println("没有操作权限异常");
    }
    
    public NoAuthException(String message) {
    	super(message);
    }
}
