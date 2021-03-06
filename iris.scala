
// Fonte:http://www.ons.org.br/historico/geracao_energia.aspx
// Formatar dados  para .csv contendo os períodes entre 2017 e 2002 ou o desejado
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.{ParamGridBuilder, TrainValidationSplit}
import org.apache.log4j._

// regula nivel de erros do logger
Logger.getLogger("org").setLevel(Level.ERROR)
// inicio sessao spark
val spark = SparkSession.builder().getOrCreate();

val data = spark.read.option("header","true").option("inferSchema","true").csv("iris.csv"); // conferirindo tipagem & importando banco dados
    println("");println("");
    println("--------+  IRIS DATA-SET   ");
    println("");
 //data.printSchema()   // conferindo tipagem
 data.show();println("");
 // println("Mes de Maio acima de 35000 GWh/h");println("");data.filter($"5" > 35000).show(); //Mes Maio com producao acima de 35000 GW/h
 // println("Melhores meses de maio");println("");data.filter($"5" > 35000).show(); //Mes Maio com producao acima de 35000 GW/h
 println("");println("--------+ Estatistica Inicial dos Dados(stddev, mean, count, max, min)");println("");data.describe().show();println("");


//Vector assembler for ml     // ("label","features")
//  println("");println("--------+ Inicio treinamento");println("");
//   val df = data.select(data("0").as("label"),$"4",$"5",$"6",$"7",$"8",$"9",$"10",$"11")
// //Criacao de vetor necessario para o treinamento do algoritmo de ML
//   val assembler = new VectorAssembler().setInputCols(Array("4","5","6","7","8","9","10","11")).setOutputCol("features"); // strings
// //Transformando vetor em duas colunas
//   println("");val output = assembler.transform(df).select($"label",$"features");println("");
// // Criacao de modelo de Regressao Linear
// val lr = new LinearRegression()
// // Treinamento do modelo ( deve-se dividir os dados primeiro, por agora iremos treinar todos os dados de uma vez)
// val lrModel = lr.fit(output)
// println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
// //Sumario e algumas metricas sobre o modelo em comparacao ao set de treinamento
// println("");println("--------+ Resumo do Treinamento");println("");
// val trainingSummary = lrModel.summary
// println(s"numIterations: ${trainingSummary.totalIterations}")
// println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}");println("");
// //Mostra os residuos da RL
// trainingSummary.residuals.show()
// println("");println("------------------------------------------------+");println("");
// println(s"RMSE (rootMeanSquaredError): ${trainingSummary.rootMeanSquaredError}");println("");
// println(s"MSE (meanSquaredError): ${trainingSummary.meanSquaredError}");println("");
// println(s"r2 (linear regression): ${trainingSummary.r2}");println("");println("------------------------------------------------+");
