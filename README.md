📚 Biblioteca Virtual - Backend em Java + Firebase
Este projeto é um backend desenvolvido em Java 21 com Spring Boot, integrado ao Firebase, que simula uma biblioteca virtual. Os usuários podem organizar livros em estantes, classificando-os como lidos ou para ler, de forma similar a plataformas como Trello ou Spotify, mas com foco exclusivo na organização pessoal de leitura.

## Estrutura do Projeto
```text
src/
├── main/
│ ├── java/
│ │ └── com/example/backend_projeto_LuizAntonioCardoso_GabrielMilano/
│ │ ├── controller/ # Controladores REST (LivroController, EstanteController)
│ │ ├── entities/ # Entidades de domínio (Livro, Estante, EstanteLivro)
│ │ ├── services/ # Lógica de negócio (LivroService, EstanteService, FirebaseService)
│ └── resources/ # Arquivos de configuração (application.properties, serviceAccount.json)

```
🔧 Tecnologias Utilizadas

Java 21

Spring Boot

Firebase Admin SDK

Gradle


🔥 Funcionalidades
📚 CRUD de livros

🗂️ CRUD de estantes

🔁 Associação de livros com estantes

☁️ Integração com Firebase para persistência de dados

🚀 Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
cd NOME_DO_REPOSITORIO
Configure o Firebase:

Insira seu arquivo serviceAccountKey.json em src/main/resources.

Acesse no navegador:


📌 Exemplos de Endpoints
Criar um novo livro
Endpoint: POST /criar/biblioteca/livro/{isbn}

Descrição: Busca informações do livro pelo ISBN e salva no Firebase.
GitHub

Criar uma nova estante
Endpoint: POST /estante/criar/{nome}

Descrição: Cria uma nova estante com o nome especificado.

Adicionar livro a uma estante
Endpoint: POST /estante/{idEstante}/adicionar-livro/{isbn}?paginaAtual=10

Descrição: Adiciona o livro com o ISBN especificado à estante, indicando a página atual de leitura.

🧩 Modelos de Dados
📘 Livro
java
Copiar
Editar
public class Livro {
    private String isbn;
    private String title;
    private String subtitle;
    private List<String> authors;
    private String synopsis;
    private Integer year;
    private Integer pageCount;
    private String genero;
    private List<String> tags;
    // Getters e Setters
}
🗄️ Estante
java
Copiar
Editar
public class Estante {
    private String id;
    private String nome;
    private String descricao;
    private String tema;
    private List<EstanteLivro> livros;
    // Getters e Setters
}
📗 EstanteLivro
java
Copiar
Editar
public class EstanteLivro {
    private String isbn;
    private int paginaAtual;
    private LocalDateTime dataAdicionado;
    // Getters e Setters
}
☁️ Integração com Firebase
A classe FirebaseService gerencia a persistência dos dados no Firebase Firestore.

java
Copiar
Editar
@Service
public class FirebaseService {
    private final Firestore db = FirestoreClient.getFirestore();

    public void salvarLivro(Livro livro) {
        db.collection("livros").document(livro.getIsbn()).set(livro);
    }

    public void salvarEstante(Estante estante) {
        db.collection("estantes").document(estante.getId()).set(estante);
    }

    public void adicionarLivroNaEstante(String idEstante, String isbn, int paginaAtual) {
        DocumentReference estanteRef = db.collection("estantes").document(idEstante);
    }
}

👨‍💻 Dupla

Luiz Antônio Cardoso

Gabriel Milano
