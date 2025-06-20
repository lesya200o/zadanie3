import jakarta.persistence.*
import jakarta.xml.bind.annotation.*

@Entity
@XmlRootElement
data class Student(
    @Id @GeneratedValue
    val id: Long? = null,

    @XmlElement
    var name: String = "",

    @OneToMany(cascade = [CascadeType.ALL])
    @XmlElement
    val skills: MutableList<Skill> = mutableListOf()
)

@Entity
data class Skill(
    @Id @GeneratedValue
    val id: Long? = null,

    @XmlValue
    var name: String = "",

    @ManyToOne
    var student: Student? = null
)