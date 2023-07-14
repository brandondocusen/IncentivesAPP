import React, { useState, useEffect } from 'react';
import Image from 'next/image';
import axios from 'axios';
import { Inter } from 'next/font/google';

const inter = Inter({ subsets: ['latin'] });

export default function Home() {
  const [students, setStudents] = useState([]);

  // Fetch student data from the Spring Boot API
  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const response = await axios.get('http://localhost:8080/students');
        setStudents(response.data);
      } catch (error) {
        console.error('Error fetching student data:', error);
      }
    };

    fetchStudents();
  }, []);

  return (
    <main
      className={`flex min-h-screen flex-col items-center justify-between p-24 ${inter.className}`}
    >
      {/* Existing code... */}

      <div>
        <h2>Student Table:</h2>
        <table>
          <thead>
            <tr>
              <th>Roll No</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Marks</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.rollNo}</td>
                <td>{student.firstName}</td>
                <td>{student.lastName}</td>
                <td>{student.marks}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </main>
  );
}