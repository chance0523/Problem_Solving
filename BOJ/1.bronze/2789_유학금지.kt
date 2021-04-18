import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    
	val cam = "CAMBRIDGE"
    val alpha = BooleanArray(26)
    cam.forEach { alpha[it.toInt() - 65]  = true }

    s.filter { !alpha[it.toInt() - 65] }.forEach{ print(it) }
    
    br.close()
}