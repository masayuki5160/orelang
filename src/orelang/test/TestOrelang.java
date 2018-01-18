package orelang.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import net.arnx.jsonic.JSON;
import orelang.Engine;

public class TestOrelang {
	
	Engine engine;
	// TODO 外部ファイルに出したい
	String example = 
			"[\"step\",\n" + 
			"  [\"set\", \"i\", 10],\n" + 
			"  [\"set\", \"sum\", 0],\n" + 
			"  [\"until\", [\"=\", [\"get\", \"i\"], 0], [\n" + 
			"    \"step\",\n" + 
			"    [\"set\", \"sum\", [\"+\", [\"get\", \"sum\"], [\"get\", \"i\"]]],\n" + 
			"    [\"set\", \"i\", [\"+\", [\"get\", \"i\"], -1]]\n" + 
			"  ]],\n" + 
			"  [\"get\", \"sum\"]\n" + 
			"]";

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
	
	@Test
	public void stepを利用したコードを実行できる() {
		Object result = engine.eval(JSON.decode(example));
		// TODO toString()してるけど他に方法がないか？
		assertThat(result.toString(), is("55"));
	}

}