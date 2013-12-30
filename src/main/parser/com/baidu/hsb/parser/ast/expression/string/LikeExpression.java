/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * (created at 2011-1-19)
 */
package com.baidu.hsb.parser.ast.expression.string;

import com.baidu.hsb.parser.ast.expression.Expression;
import com.baidu.hsb.parser.ast.expression.TernaryOperatorExpression;
import com.baidu.hsb.parser.visitor.SQLASTVisitor;

/**
 * <code>higherPreExpr 'NOT'? 'LIKE' higherPreExpr ('ESCAPE' higherPreExpr)?</code>
 * 
 * @author xiongzhao@baidu.com
 */
public class LikeExpression extends TernaryOperatorExpression {
    private final boolean not;

    /**
     * @param escape null is no ESCAPE
     */
    public LikeExpression(boolean not, Expression comparee, Expression pattern, Expression escape) {
        super(comparee, pattern, escape);
        this.not = not;
    }

    public boolean isNot() {
        return not;
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE_COMPARISION;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
