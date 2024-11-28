using APIEscola.Entities;

namespace APIEscola.Services.Interface;

public interface IAlunoService
{
    Task AdicionarAsync(Aluno aluno);
    Task AlterarAsync(Aluno aluno);
    Task ExcluirAsync(int id);
    Task <IEnumerator<Aluno>> ListarTodos();

}
