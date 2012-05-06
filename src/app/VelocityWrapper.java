package app;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;


public class VelocityWrapper{

    private Template template 		= null;
    private VelocityContext context	= new VelocityContext();
    private VelocityEngine engine	= new VelocityEngine();

	public VelocityWrapper(String templateFileName) throws IOException,Exception{

        Properties props		= new Properties();

		engine.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogSystem");
        engine.init(props);

        template			= engine.getTemplate(templateFileName);
    }

	/**
	 *
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		context.put(key, value);
	}

	/**
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws Exception
	 */
	public String merge()
		throws ResourceNotFoundException,ParseErrorException,MethodInvocationException,Exception{
		StringWriter sw		= new StringWriter();
		template.merge(context, sw);
		return sw.toString();
	}
}
