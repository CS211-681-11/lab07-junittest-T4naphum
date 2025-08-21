package ku.cs.services;

import ku.cs.models.StudentList;
import ku.cs.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    static StudentHardCodeDatasource datasource;
    static StudentList list;

    @BeforeAll
    static void init() {
        datasource = new StudentHardCodeDatasource();
        list = datasource.readData();
    }

    @Test
    @DisplayName("ทดสอบ readData() ไม่เป็น null")
    void testReadDataNotNull() {
        assertNotNull(list);
    }

    @Test
    @DisplayName("ทดสอบขนาดของ readData()")
    void testReadDataSize() {
        assertEquals(4, list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบนักเรียนคนแรกมีรหัสและชื่อถูกต้อง")
    void testFirstStudent() {
        Student s = list.getStudents().getFirst();
        assertEquals("6710400001", s.getId());
        assertEquals("First", s.getName());
    }

    @Test
    @DisplayName("ทดสอบนักเรียนคนที่2มีรหัสและชื่อถูกต้อง")
    void testSecondStudent() {
        Student s = list.getStudents().get(1);
        assertEquals("6710400002", s.getId());
        assertEquals("Second", s.getName());
    }

    @Test
    @DisplayName("ทดสอบนักเรียนคนที่3มีรหัสและชื่อถูกต้อง")
    void testThirdStudent() {
        Student s = list.getStudents().get(2);
        assertEquals("6710400003", s.getId());
        assertEquals("Third", s.getName());
    }

    @Test
    @DisplayName("ทดสอบนักเรียนคนสุดท้ายมีรหัสและชื่อถูกต้อง")
    void testLastStudent() {
        Student s = list.getStudents().get(3);
        assertEquals("6710400004", s.getId());
        assertEquals("Fourth", s.getName());
    }
}