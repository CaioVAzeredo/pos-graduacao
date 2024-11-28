using ApiEscola.Entities;

namespace ApiEscola.Services.Interfaces
{
    public interface IAlunoService
    {
        Task AdicionarAsync(Aluno aluno);
        Task AlterarAsync(Aluno aluno);
        Task ExcluirAsync(int id);
        Task <IEnumerable<Aluno>> GetAllAsync();
    }
}
