package com.chatwork.quiz.misc

/**
  * ワードをカウントするオブジェクト。
  */
object WordCounter {

  /**
    * 文字列から単語数をカウントする。
    *
    * @param words 文字列
    * @return 単語がキー、単語数がヴァリューのマップ
    */
  def countWords(words: List[String]): Map[String, Int] = {
    val result = words.flatMap { _.split(" ") }  //.flatMap { e => e.split(" ") }
                      .groupBy(identity)
//                      .map { case (k,v) => (k, v.size) }
                      .view
                      .mapValues(_.length)
                      .toMap

    println(result)

    result
  }

}
