import jakarta.persistence.*
import jakarta.xml.bind.annotation.*

@Entity
@Table(name = "students")
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "first_name")
    @XmlElement(name = "first_name")
    var firstName: String = "",

    @Column(name = "last_name")
    @XmlElement(name = "second_name")
    var lastName: String = "",

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    @XmlElement(name = "skills")
    var skills: MutableList<Skill> = mutableListOf()
)

@Entity
@Table(name = "skills")
@XmlAccessorType(XmlAccessType.FIELD)
data class Skill(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "is_hard")
    @XmlAttribute
    var hard: Boolean? = null,

    @Column(name = "is_soft")
    @XmlAttribute
    var soft: Boolean? = null,

    @Column(name = "name")
    @XmlValue
    var name: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    var student: Student? = null
)

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
data class StudentsWrapper(
    @XmlElement(name = "student")
    val students: List<Student> = emptyList()
)
