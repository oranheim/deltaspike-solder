//
// Generated by JTB 1.3.2
//

package org.jboss.seam.remoting.annotationparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> "{"
 * f1 -> MemberValue()
 * f2 -> ( "," MemberValue() )*
 * f3 -> [ "," ]
 * f4 -> "}"
 */
public class MemberValueArrayInitializer implements Node {
   public NodeToken f0;
   public MemberValue f1;
   public NodeListOptional f2;
   public NodeOptional f3;
   public NodeToken f4;

   public MemberValueArrayInitializer(NodeToken n0, MemberValue n1, NodeListOptional n2, NodeOptional n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public MemberValueArrayInitializer(MemberValue n0, NodeListOptional n1, NodeOptional n2) {
      f0 = new NodeToken("{");
      f1 = n0;
      f2 = n1;
      f3 = n2;
      f4 = new NodeToken("}");
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

