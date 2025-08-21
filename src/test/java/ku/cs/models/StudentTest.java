package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student s;
    @BeforeAll
    static void init(){
        s = new Student("6710404960", "test");
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อด้วย string + check trim")
    void testChangeNameValid() {
        s.changeName(" NewName ");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อด้วย string ว่าง")
    void testChangeNameBlank() {
        s.changeName("");
        assertEquals("test", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน")
    void testAddScore(){
        s.addScore(10);
        assertEquals(10, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบเกรดตามช่วงคะแนน และการเพิ่มคะแนน")
    void testGradeBoundaries() {
        s.addScore(80);
        assertEquals("A", s.getGrade());
        s = new Student("6712345678", "test", 70);
        assertEquals("B", s.getGrade());
        s = new Student("6712345678", "test", 60);
        assertEquals("C", s.getGrade());
        s = new Student("6712345678", "test", 50);
        assertEquals("D", s.getGrade());
        s = new Student("6712345678", "test", 49);
        assertEquals("F", s.getGrade());
    }

    @Test
    @DisplayName("ทดสอบ isId()")
    void testIsId() {
        assertTrue(s.isId("6710404960"));
        assertFalse(s.isId("6712345678"));
    }

    @Test
    @DisplayName("ทดสอบ isNameContains() โดยไม่สนตัวพิมพ์เล็ก/ใหญ่")
    void testIsNameContains() {
        assertTrue(s.isNameContains("test"));
        assertTrue(s.isNameContains("TEST"));
        assertFalse(s.isNameContains("wrong"));
    }

    @Test
    @DisplayName("ทดสอบ toString")
    void testToString(){
        Student s1 = new Student("6712345678", "Tester", 75);
        String str = s1.toString();
        assertTrue(str.contains("id: '6712345678'"));
        assertTrue(str.contains("name: 'Tester'"));
        assertTrue(str.contains("score: 75.0"));
    }

}

