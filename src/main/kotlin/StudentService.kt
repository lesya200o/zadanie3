import org.springframework.stereotype.Service
import jakarta.xml.bind.JAXBContext
import java.io.File

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun processXml(filePath: String) {
        val file = File(filePath)
        val student = JAXBContext.newInstance(Student::class.java)
            .createUnmarshaller()
            .unmarshal(file) as Student

        studentRepository.save(student)
    }
}