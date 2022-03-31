package sk.lacike.example.springboot.settings;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SturTest {

	@Test
	public void test() {
		SturLexer lexer = new SturLexer(CharStreams.fromString("dehelle (le) {ne} worlde ti ty"));
		ParseTree tree = new SturParser(new CommonTokenStream(lexer)).sentence();

		SturCreator sturCreator = new SturCreator();
		new ParseTreeWalker().walk(sturCreator, tree);

		Assert.assertEquals(sturCreator.toString(), "ďehelľe (le) {ne} worlďe ťi ti");
	}

	private static class SturCreator extends SturBaseListener {

		private final Map<Character, Character> replacement = ImmutableMap.of('d', 'ď', 't', 'ť', 'n', 'ň', 'l', 'ľ');
		private final StringBuilder sb = new StringBuilder();

		@Override
		public void enterHardLetterToSoft(SturParser.HardLetterToSoftContext ctx) {
			char charToSoften = ctx.getText().charAt(0);
			sb.append(replacement.get(charToSoften));
			sb.append(ctx.getText().substring(1));
		}

		@Override
		public void enterAnyChar(SturParser.AnyCharContext ctx) {
			sb.append(ctx.getText().replace('y', 'i'));
		}

		@Override
		public void enterBrackets(SturParser.BracketsContext ctx) {
			sb.append(ctx.getText());
		}

		@Override
		public void visitErrorNode(ErrorNode node) {
			sb.append(node.getText());
		}

		public String toString() {
			return sb.toString();
		}
	}
}
