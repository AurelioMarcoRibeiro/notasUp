import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Digite os nomes dos alunos separados por uma vírgula:")
    val studentsName = scanner.nextLine()
    val names = studentsName.split(",").map { it.trim() }

    println("Digite as notas dos alunos separados por uma vírgula:")
    val notesEntry = scanner.nextLine()
    val notes = mutableListOf<Double>()

    notesEntry.split(",").forEach {
        val notesEntry = it.trim().toDoubleOrNull()
        if (notesEntry != null) {
            notes.add(notesEntry)
        }
    }

    println("Digite o valor da média:")
    val minimumAverage = scanner.nextDouble()

    println("Alunos com notas acima da média:")
    for (generalNotes in notes.indices) {
        if (notes[generalNotes] >= minimumAverage) {
            println(names[generalNotes])
        }
    }
    println("Alunos com notas abaixo da média")
    for (generalNotes in notes.indices) {
        if (notes[generalNotes] < minimumAverage) {
            println(names[generalNotes])
        } }

    println("Deseja editar as notas dos alunos? (S/N)")
    val editNotes = scanner.next()

    if (editNotes.equals("S", ignoreCase = true)) {
        for (updatedNotes in notes.indices) {
            println("Digite a nova nota para ${names[updatedNotes]}")
            val newScore = scanner.nextDouble()
            notes[updatedNotes] = newScore
        }

        val newAverage = notes.average()
        println(
            "As médias dos alunos foram atualizadas, seguem as informações:\n" +
                    "Alunos com notas acima da média:"
        )

        for (updatedNotes in notes.indices) {
            if (notes[updatedNotes] >= minimumAverage) {
                println(names[updatedNotes])
            }
        }

        println("Alunos com notas abaixo da média:")
        for (updatedNotes in notes.indices) {
            if (notes[updatedNotes] < minimumAverage) {
                println(names[updatedNotes])
            }
        }

        println("Obrigado!")

    } else{
        editNotes.equals("", ignoreCase = true)
        println("Obrigado!")
    }
}