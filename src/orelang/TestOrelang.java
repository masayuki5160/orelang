package orelang;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import net.arnx.jsonic.JSON;

public class TestOrelang {
	
	Engine engine;

	@Before
	public void setUp() {
		engine = new Engine();
	}

	@Test
	public void 簡単な四則演算を実行できる() {
		Object result = engine.eval(JSON.decode("[\"+\", 1, 2, [\"*\", 3, 4]]"));
		
		// TODO toString()してるけど他に方法がないか？
		assertThat(result.toString(), is("15"));
	}

}
