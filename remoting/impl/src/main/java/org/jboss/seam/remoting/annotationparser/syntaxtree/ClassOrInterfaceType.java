//
// Generated by JTB 1.3.2
//

package org.jboss.seam.remoting.annotationparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <IDENTIFIER>
 * f1 -> ( "." <IDENTIFIER> )*
 * f2 -> [ "." "class" ]
 */
public class ClassOrInterfaceType implements Node {
   public NodeToken f0;
   public NodeListOptional f1;
   public NodeOptional f2;

   public ClassOrInterfaceType(NodeToken n0, NodeListOptional n1, NodeOptional n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public void accept(org.jboss.seam.remoting.annotationparser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.jboss.seam.remoting.annotationparser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.jboss.seam.remoting.annotationparser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.jboss.seam.remoting.annotationparser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

