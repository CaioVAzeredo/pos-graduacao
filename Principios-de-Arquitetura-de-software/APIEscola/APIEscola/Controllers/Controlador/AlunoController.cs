using APIEscola.Entities;
using APIEscola.Services.Interface;
using Microsoft.AspNetCore.Mvc;

namespace APIEscola.Controllers.Controlador;
[ApiController]
[Route("api/[controller]")]
public class AlunoController : Controller
{
    private IAlunoService _alunoService;
    [HttpGet]
    public IActionResult ListarTodosAlunos()
    {
        return Ok(_alunoService.ListarTodos());
    }
    [HttpPost]
    public IActionResult AdicionarAluno([FromBody] Aluno aluno)
    {
        if (aluno == null)
        {
            return BadRequest();
        }

        return Ok(_alunoService.AdicionarAsync(aluno));
    }
    [HttpPut]
    public IActionResult AlterarAluno([FromBody] Aluno aluno)
    {
        if (aluno == null)
        {
            return BadRequest();
        }

        return Ok(_alunoService.AlterarAsync(aluno));
    }
    [HttpDelete("{id}")]
    public IActionResult ExcluirAluno(int id)
    {
        _alunoService.ExcluirAsync(id);
        return NoContent();
    }
}