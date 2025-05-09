📚 Biblioteca Virtual - Projeto Backend
Este é um projeto de backend desenvolvido em Java utilizando o Spring Boot e integração com o Firebase, com o objetivo de simular uma biblioteca virtual. Nele, os usuários podem organizar livros em estantes, classificando-os como lidos ou para ler, de forma similar a plataformas como Trello ou Spotify, porém com foco exclusivo na organização pessoal de leitura.

📁 Estrutura do Projeto
bash
Copiar
Editar
src/
├── main/
│   ├── java/com/example/backend_projeto_LuizAntonioCardosoGabriel/
│   │   ├── controller/      # Controladores REST (LivroController, EstanteController)
│   │   ├── entities/        # Entidades JPA (Livro, Estante, EstanteLivro)
│   │   ├── services/        # Lógica de negócio (LivroService, EstanteService, FirebaseService)
│   ├── resources/           # Arquivos de configuração
├── test/                    # Testes unitários
🔧 Tecnologias Utilizadas
Java 17

Spring Boot

Firebase Admin SDK

Gradle

JPA / Hibernate

🔥 Funcionalidades
📚 CRUD de livros

🗂️ CRUD de estantes

🔁 Associação de livros com estantes

📌 Organização de livros por status (lido, para ler)

☁️ Integração com Firebase para autenticação ou persistência (conforme seu código)

🚀 Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
cd NOME_DO_REPOSITORIO
Configure o Firebase:

Insira seu arquivo firebase-adminsdk.json em src/main/resources ou configure nas variáveis de ambiente.

Compile e execute:

bash
Copiar
Editar
./gradlew bootRun
Acesse no navegador:

arduino
Copiar
Editar
http://localhost:8080
📌 Exemplos de Endpoints
GET /estantes - Lista todas as estantes

POST /livros - Cadastra um novo livro

PUT /estantes/{id}/livros - Adiciona livro a uma estante

GET /estantes/{id}/livros - Lista livros de uma estante

👨‍💻 Autores
Luiz Antônio Cardoso

Gabriel Milano Alves
