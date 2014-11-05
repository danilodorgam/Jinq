package org.jinq.jpa.transform;

public class ScalaLambdaInfo extends LambdaInfo
{
   String className;

   protected ScalaLambdaInfo(Object lambdaObject, 
         int lambdaIndex, int numCapturedArgs,
         int numLambdaArgs)
   {
      super(lambdaIndex, numCapturedArgs, numLambdaArgs);
      this.Lambda = lambdaObject;
      className = lambdaObject.getClass().getName();
   }

   @Override
   public String getLambdaSourceString()
   {
      return className;
   }

   @Override
   public LambdaAnalysis fullyAnalyze(MetamodelUtil metamodel, ClassLoader alternateClassLoader, boolean isObjectEqualsSafe, boolean throwExceptionOnFailure)
   {
      return LambdaAnalysis.fullyAnalyzeClassAsLambda(this, "apply", numLambdaArgs, metamodel, alternateClassLoader, isObjectEqualsSafe, throwExceptionOnFailure);
   }

}
