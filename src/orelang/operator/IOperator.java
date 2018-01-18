package orelang.operator;

import java.util.List;

import orelang.Engine;

public interface IOperator {
	Object call(Engine engin, List<?> args);
}
