using ApiEscola.Entities;
using ApiEscola.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace ApiEscola.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class AlunoController : Controller
    {
        private IAlunoService _alunoService;

        [HttpGet] 
        public IActionResult ListarTodosAlunos()
        {

            return Ok(_alunoService.GetAllAsync()); 
        }
        [HttpPost]
        public IActionResult AdicionarAluno([FromBody] Aluno aluno)
        {
            if(aluno == null)
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
}
