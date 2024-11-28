using APIEscola.Data.Context;
using APIEscola.Entities;
using APIEscola.Services.Interface;
using Microsoft.EntityFrameworkCore;

namespace APIEscola.Services.Implementation;

public class AlunoServices : IAlunoService
{
    private SQLServerContext _context;

    public AlunoServices(SQLServerContext context)
    {
        _context = context;
    }

    public async Task AdicionarAsync(Aluno aluno)
    {
        _context.ALunos.Add(aluno);
        await _context.SaveChangesAsync();
    }

    public async Task AlterarAsync(Aluno aluno)
    {
        _context.ALunos.Update(aluno);
        await _context.SaveChangesAsync();
    }

    public async Task ExcluirAsync(int id)
    {
        var aluno = await _context.ALunos.FindAsync(id);
        if (aluno != null)
        {
            _context.ALunos.Remove(aluno);
            await _context.SaveChangesAsync();
        }
    }

    public async Task<IEnumerable<Aluno>> ListarTodos()
    {
        return await _context.ALunos.ToListAsync();
    }
}
