// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

val listaId: MutableList<Int> =  mutableListOf()

val checkIdList:(Int,MutableList<Int>) -> Boolean =  {id:Int, lista:MutableList<Int> -> id !in lista}

fun criarUsuario(nome: String, id: Int) =  if (checkIdList(id, listaId)) 
{listaId.add(id);Usuario(nome, id)} else  throw Exception("Usuario com id: $id ja Existe, O ID deve ser unico")

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val id: Int )

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
	
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) = if (usuario !in inscritos) {println("Usuario ${usuario.nome} inscrito com Sucesso em: ${this.nome} "); inscritos.add(usuario)}
    else println("Usuario ${usuario.nome} ja inscrito em ${this.nome} ")
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    
    fun verificarMatriculados(){
        println(inscritos)
    }
}

fun main() {
    // Simulando criacao de Usuarios
    val gabriel = criarUsuario("Gabriel",1)
    //val vinicius2 = criarUsuario("Vinicius", 1)  //- Simulando Erro de usuario com mesmo id(deve ser unico)
    val vinicius = criarUsuario("Vinicius",2)
    val mateus = criarUsuario("Mateus", 3)
    val wilson = criarUsuario("Wilson", 4 )
    
    // Criação de conteudos Educacionais
    val logicaProgramacao = ConteudoEducacional("Logica de Programacao", 240)
    val gitHubIntroduction = ConteudoEducacional("Introducao Ao GitHub", 90)
    val kotlinInitial = ConteudoEducacional("Iniciando no Kotlin", 60)
    val kotlinVariables = ConteudoEducacional("Variaveis no Kotlin", 120)
    val kotlinclass = ConteudoEducacional("Classes em Kotlin", 100)
    val kotlinFunctions = ConteudoEducacional("Funções em Kotlin", 45)
    val kotlinCollections = ConteudoEducacional("Controles de Fluxo em Kotlin",70)
    val javaInitial = ConteudoEducacional("Iniciando no Java", 60)
    val javaVariables = ConteudoEducacional("Variaveis no Java", 120)
    val javaclass = ConteudoEducacional("Classes em Java", 100)
    val javaFunctions = ConteudoEducacional("Funções em Java", 45)
    val javaCollections = ConteudoEducacional("Controles de Fluxo em Java",70)
    
	
    // Criacao de listas de cursos
    val cursosIniciantes:List<ConteudoEducacional> = listOf(logicaProgramacao,gitHubIntroduction)
    val cursosKotlin:List<ConteudoEducacional> = listOf(kotlinclass,kotlinCollections,kotlinFunctions,kotlinInitial,kotlinVariables)
    val cursosJava:List<ConteudoEducacional> = listOf(javaclass,javaCollections,javaFunctions,javaInitial,javaVariables)
    val cursosJavaEKotlin:List<ConteudoEducacional> = listOf(kotlinclass,kotlinCollections,kotlinFunctions,kotlinInitial,kotlinVariables
                                                             ,javaclass,javaCollections,javaFunctions,javaInitial,javaVariables)

	// Criacao de formações
    val iniciandoNaProgramacao = Formacao("Primeiros passos em Programacao", cursosIniciantes , Nivel.BASICO)
    val formacaoKotlin = Formacao("Formação Kotlin", cursosKotlin, Nivel.INTERMEDIARIO)
    val formacaoJava= Formacao("Formacao Java", cursosJava , Nivel.INTERMEDIARIO)
    val formacaoJavaEKotlin = Formacao("Primeiros passos em Programacao", cursosJavaEKotlin, Nivel.AVANCADO)
	
    iniciandoNaProgramacao.matricular(vinicius)
    iniciandoNaProgramacao.matricular(vinicius)
    iniciandoNaProgramacao.matricular(wilson)
   

}
