package br.com.professorisidro.isilanguage.ast;

public class CommandAtribuicao extends AbstractCommand {

	private String id;
	private String expr;

	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}

	@Override
	public String generateCode(String language) {
		return id + " = " + expr + ";";
	}

	@Override
	public String toString() {
		return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
	}

	public String getId() {
		return id;
	}

	public String getExpr() {
		return expr;
	}

}
