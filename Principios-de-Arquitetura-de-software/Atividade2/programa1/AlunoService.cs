using ApiEscola.Data.Context;
using ApiEscola.Entities;
using ApiEscola.Services.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace ApiEscola.Services.Implementation
{
    public class AlunoService:IAlunoService
    {
        private SQLServerContext _context;

        public AlunoService(SQLServerContext context)
        {
            _context = context;
        }

        public async Task AdicionarAsync(Aluno aluno)
        {
            _context.Alunos.Add(aluno);
            await _context.SaveChangesAsync();
        }

        public async Task AlterarAsync(Aluno aluno)
        {
            _context.Alunos.Update(aluno);
            await _context.SaveChangesAsync();
        }

        public async Task ExcluirAsync(int id)
        {
            var aluno = await _context.Alunos.FindAsync(id);
            if(aluno != null) {
                _context.Alunos.Remove(aluno);
                await _context.SaveChangesAsync();
            }
        }

        public async Task<IEnumerable<Aluno>> GetAllAsync()
        {
            return await _context.Alunos.ToListAsync();
        }
    }
}
