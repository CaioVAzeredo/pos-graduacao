using APIEscola.Entities;
using Microsoft.EntityFrameworkCore;

namespace APIEscola.Data.Context;

public class MySQLContext : DbContext
{
    public MySQLContext(DbContextOptions<MySQLContext> options) : base(options)
    {
    }

    public DbSet<Aluno> Alunos { get; set; } 
}
