package orelang.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import orelang.Engine;

public class TestOrelang {
	
	Engine engine;

	@Before
	public void setUp() {
		engine = new Engine();
	}

	@Test
	public void 簡単な四則演算を実行できる() throws JSONException, FileNotFoundException, IOException {
		Object result = engine.eval(JSON.decode(new FileReader("src/orelang/test/testAddOp.json")));
		
		// TODO toString()してるけど他に方法がないか？
		assertThat(result.toString(), is("15"));
	}
	
	@Test
	public void stepを利用したコードを実行できる() throws JSONException, FileNotFoundException, IOException {
		Object result = engine.eval(JSON.decode(new FileReader("src/orelang/test/testStepOp.json")));
		// TODO toString()してるけど他に方法がないか？
		assertThat(result.toString(), is("55"));
	}

}
