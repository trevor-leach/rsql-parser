package cz.jirutka.rsql.parser.ast;

import net.jcip.annotations.Immutable;

import java.util.List;

@Immutable
public final class NotNode extends LogicalNode {

    public NotNode(List<? extends Node> children) {
        super(LogicalOperator.NOT, children);
    }

    public NotNode withChildren(List<? extends Node> children) {
        return new NotNode(children);
    }

    public <R, A> R accept(RSQLVisitor<R, A> visitor, A param) {
        return visitor.visit(this, param);
    }

    @Override
    public String toString() {
        return "(" + getOperator().toString() + getChildren().toString() + ")";
    }
}
