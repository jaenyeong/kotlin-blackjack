package study.resume

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/*
introduce {
    name("김재녕")
    company("HDJ")
    skills {
        soft ("A passion for problem solving")
        soft ("Good communication skills")
        hard ("Kotlin")
    }
    languages {
        "Korean" level 5
        "English" level 3
    }
}
 */

internal class ResumeTest {
    @Test
    fun name() {
        val person = introduce {
            name("김재녕")
        }
        assertThat(person.name).isEqualTo("김재녕")
    }

    @Test
    fun company() {
        val person = introduce {
            name("김재녕")
            company("HDJ")
        }
        assertThat(person.company).isEqualTo("HDJ")
    }

    @Test
    fun softSkill() {
        val person = introduce {
            name("김재녕")
            company("HDJ")
            skills {
                soft("A passion for problem solving")
            }
        }
        assertThat(person.skills).contains(Soft("A passion for problem solving"))
    }

    @Test
    fun hardSkill() {
        val person = introduce {
            name("김재녕")
            company("HDJ")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
        }
        assertThat(person.skills).contains(
            Soft("A passion for problem solving"),
            Soft("Good communication skills"),
            Hard("Kotlin")
        )
    }

    @Test
    fun languages() {
        val person = introduce {
            name("김재녕")
            company("HDJ")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
            languages {
                "Korean" level 5
                "English" level 3
            }
        }
        assertThat(person.languages).contains(
            Language("Korean", 5),
            Language("English", 3)
        )
    }
}
