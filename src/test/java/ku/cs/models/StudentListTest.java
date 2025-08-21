package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    static StudentList list;

    @BeforeAll
    static void init() {
        list = new StudentList();
        list.addNewStudent("6710400001", "First");
        list.addNewStudent("6710400002", "Second", 70);
        list.addNewStudent("6710400003", "Third");
        list.addNewStudent("6710400004", "Fourth", 80);
    }

    @Test
    @DisplayName("ตรวจสอบจำนวนนักเรียน")
    void testSize() {
        assertEquals(4, list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบไม่ให้เพิ่มนักเรียนซ้ำ")
    void testAddDuplicateStudent() {
        list.addNewStudent("6710400001", "FirstTest");
        assertEquals(4, list.getStudents().size());
        assertEquals("First", list.findStudentById("6710400001").getName());
    }

    @Test
    @DisplayName("ทดสอบไม่ให้เพิ่มนักเรียนที่มี id หรือ name ว่าง")
    void testAddInvalidStudent() {
        list.addNewStudent("", "NoID");
        list.addNewStudent("12345", "");
        assertEquals(4, list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบ findStudentById()")
    void testFindStudentById() {
        assertNotNull(list.findStudentById("6710400001"));
        assertEquals("First", list.findStudentById("6710400001").getName());
        assertNull(list.findStudentById("9999999999"));
    }

    @Test
    @DisplayName("ทดสอบ filterByName()")
    void testFilterByName() {
        StudentList filtered = list.filterByName("f");
        assertEquals(2, filtered.getStudents().size());
        assertTrue(filtered.getStudents().stream().anyMatch(s -> s.getName().equals("First")));
        assertTrue(filtered.getStudents().stream().anyMatch(s -> s.getName().equals("Fourth")));
    }

    @Test
    @DisplayName("ทดสอบ giveScoreToId() เพิ่มคะแนนให้นักเรียน")
    void testGiveScoreToId() {
        list.giveScoreToId("6710400003", 60);
        assertEquals(60, list.findStudentById("6710400003").getScore());
    }

    @Test
    @DisplayName("ทดสอบ viewGradeOfId()")
    void testViewGradeOfId() {
        assertEquals("A", list.viewGradeOfId("6710400004"));
        assertEquals("B", list.viewGradeOfId("6710400002"));
        assertNull(list.viewGradeOfId("9999999999"));
    }

}