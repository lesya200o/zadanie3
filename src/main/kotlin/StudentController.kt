import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/students")
class StudentController(private val service: StudentService)
{

    @PostMapping("/upload")
    fun upload(@RequestParam file: MultipartFile): String {
        val tempFile = File.createTempFile("temp", ".xml").apply {
            file.transferTo(this)
        }
        service.processXml(tempFile.absolutePath)
        return "Файл обработан!"
    }
}