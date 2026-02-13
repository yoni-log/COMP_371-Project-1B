package topwords

trait WordCloudObserver {
  def update(stats: List[(String, Int)]): Unit
}

class ConsoleObserver extends WordCloudObserver {
  def update(stats: List[(String, Int)]): Unit = {
    val formatted = stats
      .map { case (word, freq) => s"$word: $freq" }
      .mkString(" ")
    
    System.out.println(formatted)
    System.out.flush()
  }
}

