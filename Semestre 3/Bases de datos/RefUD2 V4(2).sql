-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 24, 2024 at 11:56 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `RefUD2`
--

-- --------------------------------------------------------

--
-- Table structure for table `Curso`
--

CREATE TABLE `Curso` (
  `idCurso` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `TipoCurso_idTipoCurso` int(11) NOT NULL,
  `Programa_idPrograma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Curso`
--

INSERT INTO `Curso` (`idCurso`, `nombre`, `TipoCurso_idTipoCurso`, `Programa_idPrograma`) VALUES
(1, 'Programacion Orientada a Objetos', 4, 11),
(2, 'Bases de Datos', 4, 11),
(3, 'Calculo Diferencial', 4, 11),
(4, 'Calculo Integral', 4, 11),
(5, 'Fisica', 4, 11),
(6, 'Diseño Lógico', 4, 11),
(7, 'Ecuaciones Diferenciales', 1, 5),
(8, 'Programación Multinivel', 1, 11),
(9, 'Estructura de Datos', 1, 11),
(10, 'Catedra de Contexto', 4, 11),
(11, 'Introducción a algoritmos', 4, 11);

-- --------------------------------------------------------

--
-- Table structure for table `Denuncia`
--

CREATE TABLE `Denuncia` (
  `Referencia_Profesor_idProfesor` int(11) NOT NULL,
  `Referencia_Curso_idCurso` int(11) NOT NULL,
  `Referencia_Estudiante_idEstudiante` int(11) NOT NULL,
  `Referencia_periodo` varchar(45) NOT NULL,
  `Estudiante_idEstudiante` int(11) NOT NULL,
  `argumento` text NOT NULL,
  `TipoDenuncia_idTipoDenuncia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Estudiante`
--

CREATE TABLE `Estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `periodoIngreso` varchar(45) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `genero` char(1) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Estudiante`
--

INSERT INTO `Estudiante` (`idEstudiante`, `nombre`, `apellido`, `correo`, `clave`, `periodoIngreso`, `fechaNacimiento`, `genero`, `estado`) VALUES
(1, 'Natalia', 'Herrera', 'nherrerag@udistrital.edu.co', '123456', '2023-1', '2002-11-11', 'F', 1),
(2, 'DANIEL LEONARDO', 'LOPEZ VALDERRAMA', 'dllopezv@udistrital.edu.co', 'melapela2024', '2023-1', '2006-10-16', 'M', 1),
(13, 'Dana Sofia', 'Macias Rojas', 'dsofiamrojasd6419@gmail.com', 'Qmsr123', '2023-1', '2005-07-24', 'F', 1),
(20, 'Daniel', 'Rozo', 'dalarrottar@udistritral.edu.co', '1234', '2022-3', '2003-07-02', 'M', 1),
(25, 'Ashley Vanesa', 'Rico Monroy', 'ashleyvansear@gmail.com', 'AshleyRico', '2023-1', '2005-09-08', 'F', 1),
(30, 'Jonathan Sebastian', 'Bernal Vargas', 'josbernalv@udistrital.edu.co', 'contraseñaUniversidad', '2023-1', '2005-10-21', 'm', 1),
(35, 'Fabian', 'Salas', 'flsalast@udistrital.edu.co', '12134', '2022-2', '2001-11-28', 'M', 1),
(50, 'Juan', 'Leiton', 'jdleitonp@udistrital.edu.co', 'MyContra123', '2023-1', '2004-05-20', 'M', 1),
(72, 'Daniel Esteban', 'Pardo Moreno', 'depardom@udistrital.edu.co', 'dan23@', '2022-2', '2001-10-12', 'M', 1),
(74, 'Cristian Daniel', 'Feo Patarroyo', 'cdfeop@udistrital.edu.co', '123456', '2022-2', '2004-10-07', 'M', 1),
(75, 'Diego', 'Rueda', 'daruedav@udistrital.edu.co', 'diego123', '2022-2', '2024-10-14', 'M', 1),
(78, 'Gabriel Felipe', 'Gomez Ramirez', 'gfgomezr@udistrital.edu.co', '12345678', '2023-1', '2005-07-10', 'M', 1),
(83, 'Bryan', 'Molano', 'bsmolanof@udistrital.edu.co', 'BM3108', '2023.01', '2005-08-31', 'M', 1),
(110, 'Luisa', 'Parra', 'lfparrav@udistrital.edu.co', 'lulu1203', '2022-2', '2000-03-15', 'F', 1),
(120, 'Oscar', 'Gonzalez', 'oagonzalezs@udistrital.edu.co', 'Jkt.Iwdfy.1.31', '2023-1', '2005-08-14', 'M', 1),
(127, 'Cristhian', 'Fabra', 'cristhiandavidfl@gmail.com', 'cristhianfl001', '2023-1', '2006-01-03', 'M', 1),
(128, 'Juan Esteban', 'Bojaca Machuca', 'jebojacam@udistrital.edu.co', 'lakfij152731', '2021-1', '1999-11-17', 'M', 1),
(178, 'Andres', 'Carvajal', 'afcarvajalr@udistrital.edu.co', '3456', '2023-1', '2006-05-08', 'M', 1),
(278, 'Andres', 'Carvajal', 'afcarvajalr@udistrital.edu.co', '3456', '2023-1', '2006-05-08', 'M', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Facultad`
--

CREATE TABLE `Facultad` (
  `idFacultad` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Facultad`
--

INSERT INTO `Facultad` (`idFacultad`, `nombre`) VALUES
(2, 'Facultad de Artes - ASAB'),
(3, 'Facultad de Ciencias y Educación'),
(4, 'Facultad de Ciencias de la Salud'),
(5, 'Facultad de Ingeniería'),
(6, 'Facultad Tecnológica'),
(7, 'Facultad de Ciencias Matemáticas y Naturales '),
(8, 'Facultad del Medio Ambiente y Recursos Naturales');

-- --------------------------------------------------------

--
-- Table structure for table `Profesor`
--

CREATE TABLE `Profesor` (
  `idProfesor` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `genero` char(1) NOT NULL,
  `TipoContrato_idTipoContrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Profesor`
--

INSERT INTO `Profesor` (`idProfesor`, `nombre`, `apellido`, `genero`, `TipoContrato_idTipoContrato`) VALUES
(1, 'Hector', 'Florez', 'M', 1),
(2, 'Hector', 'Fuquene', 'M', 1),
(3, 'Miller', 'Gomez', 'M', 1),
(4, 'Nelson', 'Vargas', 'M', 4),
(5, 'Rocio', 'Rodriguez', 'F', 1),
(6, 'Jorge', 'Hernandez', 'M', 3),
(7, 'Eusebio', 'Avendaño', 'M', 4),
(8, 'Carlos', 'Vanegas', 'M', 1),
(9, 'Luis Felipe', 'Wanumen Silva', 'M', 1),
(10, 'Nelson Reynaldo', 'Becerra Correa', 'M', 1),
(11, 'Mariluz', 'Romero', 'F', 1),
(12, 'HERMETH', 'PÉREZ CARO', 'M', 4);

-- --------------------------------------------------------

--
-- Table structure for table `Programa`
--

CREATE TABLE `Programa` (
  `idPrograma` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `Facultad_idFacultad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Programa`
--

INSERT INTO `Programa` (`idPrograma`, `nombre`, `Facultad_idFacultad`) VALUES
(1, 'Administración Ambiental', 8),
(2, 'Ingenieria Civil', 6),
(3, 'Administración Deportiva', 8),
(4, 'Ingeniería Industrial', 6),
(5, 'Ingenieria Telematica ', 6),
(6, 'Tecnología en Saneamiento Ambiental', 8),
(7, 'administración deportiva', 8),
(8, 'Biología', 7),
(9, 'Ingenieria Catastral', 5),
(10, 'Arte Danzario', 2),
(11, 'Tecnología en Sistematización de Datos', 6);

-- --------------------------------------------------------

--
-- Table structure for table `RangoNota`
--

CREATE TABLE `RangoNota` (
  `idRangoNota` int(11) NOT NULL,
  `valor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `RangoNota`
--

INSERT INTO `RangoNota` (`idRangoNota`, `valor`) VALUES
(1, '< 3.0'),
(2, '3.1 - 4.0'),
(3, '4.1 - 5.0');

-- --------------------------------------------------------

--
-- Table structure for table `Referencia`
--

CREATE TABLE `Referencia` (
  `Profesor_idProfesor` int(11) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL,
  `Estudiante_idEstudiante` int(11) NOT NULL,
  `periodo` varchar(45) NOT NULL,
  `comentario` text NOT NULL,
  `pros` text DEFAULT NULL,
  `contras` text DEFAULT NULL,
  `fecha` date NOT NULL,
  `dominio` int(11) NOT NULL,
  `metodologia` int(11) NOT NULL,
  `exigencia` int(11) NOT NULL,
  `amabilidad` int(11) NOT NULL,
  `puntualidad` int(11) NOT NULL,
  `imparcialidad` int(11) NOT NULL,
  `actitud` int(11) NOT NULL,
  `cumplimientoSyllabus` int(11) NOT NULL,
  `dificultadParciales` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `RangoNota_idRangoNota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Referencia`
--

INSERT INTO `Referencia` (`Profesor_idProfesor`, `Curso_idCurso`, `Estudiante_idEstudiante`, `periodo`, `comentario`, `pros`, `contras`, `fecha`, `dominio`, `metodologia`, `exigencia`, `amabilidad`, `puntualidad`, `imparcialidad`, `actitud`, `cumplimientoSyllabus`, `dificultadParciales`, `estado`, `RangoNota_idRangoNota`) VALUES
(1, 1, 74, '2023-1', 'es un buen docente, se nota que conoce los temas que explica y sabe hacer dinamica una clase ', NULL, NULL, '2024-03-10', 4, 4, 5, 4, 4, 5, 4, 5, 4, 1, 1),
(1, 1, 83, '2023-1', 'Su forma de pasar temas es aceptable y es paciente con los estudiantes', NULL, NULL, '2024-03-19', 4, 3, 5, 3, 5, 5, 4, 4, 5, 1, 1),
(1, 2, 20, '2023-3', 'Las clases son muy dinamicas, es un profesor que sabe del tema y enseña bien, se aprende mucho en esa materia.', 'Se sale con buenas bases para el siguiente curso, Desarrolla mucho la logica, Hace las clases dinamicas.', 'NA.', '2024-03-15', 5, 5, 5, 4, 5, 1, 5, 5, 4, 1, 2),
(1, 2, 72, '2024-1', 'es un buen docente dinamico que lleva las clases de manera didactica y entretenida para la atencion de sus estudiantes junto al desarollo de su proceso academico', 'didactico, divertido, entretenido y claro', 'duro al calificar', '2024-02-01', 5, 5, 5, 4, 5, 5, 5, 4, 5, 1, NULL),
(1, 2, 78, '3', '	Es un profe bastante entretenido, explica bien los temas', '', '', '2023-08-10', 5, 4, 4, 5, 5, 3, 5, 4, 4, 1, NULL),
(1, 2, 110, '2024-1', 'Sus explicaciones son claras y precisas, es exigente pero se aprende mucho.', 'Las clases son dinámicas por los concursos', 'Las clases son un poco largas.', '2024-03-19', 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 2),
(1, 2, 120, '2024-1', 'Es un profesor que de forma sustancial maneja una metodología entretenida, lo que hace que  sus clases sean entretenidas, adicionalmente, es un profesor que domina bien el temario de la asignatura, que en mi criterio es importante al momento de enseñar, y en general me agrada porque sabe qué enseñar y como enseñar', NULL, NULL, '2024-04-08', 5, 5, 4, 5, 5, 4, 5, 5, 3, 1, NULL),
(1, 2, 127, '2024-1', 'Su metodología de enseñanza es distinta a la del resto, volviendo la clase más didáctica y haciendo así que todos puedan participar, aprendiendo uno en el proceso. Es un muy buen profesor si quiere aprender bastante con algo de exigencia.', 'Clase entretenida, buena enseñanza, un gran dominio en el tema', 'Nos asesina nuestro trabajito :<', '2024-03-18', 5, 5, 3, 4, 5, 4, 5, 4, 3, 1, NULL),
(2, 1, 1, '2023-2', 'Su metodologia de clase no es la mejor, y es de un caracter temperamental, pero si se presta atencion a clase se puede aprender bastante.', '- Da alternativas a parciales (Como proyectos en vez de parciales) - A veces califica trabajos que no se pudieron presentar a tiempo. ', '- No suele resolver dudas - No deja entrar al salon si se llega despues de 15 minutos iniciada la clase sin importar si hay una buena razon de la llegada tarde - Su forma de explicar puede llegar a ser aburrida.', '2024-03-19', 4, 3, 4, 3, 5, 4, 3, 4, 3, 1, 2),
(2, 1, 2, '2023-3', 'Es un profesor que no tiene pedagogía pero el estudiante aprende a las malas. El lenguaje de la materia es en C++. Es estricto y serio. Hay que tener mucho trabajo autónomo y no dejarse colgar en talleres. Tiene poca paciencia y no es capaz de reconocer sus errores fácilmente', 'Los conceptos quedan muy claros', 'Parciales en hojas examen. No aclara cómo quiere que se presenten los programas de C++. Poca paciencia y poca pedagogía', '2024-03-19', 4, 4, 5, 2, 4, 4, 3, 4, 4, 1, 3),
(2, 1, 20, '2023-3', 'Es un profesor que sabe del tema de la materia y tiene buenas habilidades, pero la comunicacion no es su fuerte, puede llegar a ser desgastante tratar con el.', 'Se aprende mucho en su materia, Exige que uno trabaje y practique del temario.', 'Puede llegar a ser imparcial con las notas, No se comunica de la mejor manera.', '2023-09-02', 5, 4, 5, 3, 5, 2, 4, 4, 4, 1, 1),
(2, 1, 25, '2023-1', 'Es un profesor muy exigente,tiene que ser muy cumplido con las actividades que deja.', '', '', '2024-03-12', 5, 2, 5, 1, 5, 3, 2, 5, 5, 1, 1),
(2, 1, 30, '2024-1', 'El profesor esta acostumbrado a la vieja escuela, hace parciales a mano de referente a algun ejercicio que dicta el mismo dia, ademas enseña en lenguaje c++, lo cual dificulta al curso programacion multinivel que es programacion en java', 'esta dispuesto a ayudarte en cualquier duda', 'el lenguaje utilizado, no es de calificar y cada trabajo realizado se debera re actulizar con lo explicado en clase en momentos sin que el te diga, puede llegar a decir comentarios machistas ', '2024-03-17', 5, 4, 5, 4, 5, 1, 3, 5, 4, 1, 2),
(2, 1, 35, '2021', ' se aprende pero trabajar sobre linux es  un obstáculo ya que lo explica muy  superficial', 'explica bien', 'linux', '2022-06-01', 5, 3, 4, 3, 5, 3, 4, 4, 4, 1, 2),
(2, 1, 78, '2', 'Me parecio un mal profe, no explicaba bien los temas, no respondia dudas, solia ser ofensivo no me gusto la materia con el para nada', '', '', '2023-08-10', 3, 1, 5, 1, 3, 1, 1, 2, 3, 1, NULL),
(2, 2, 13, '2024-1', 'Tiene una metodologia organizada y completa, desarrolla muy bien los temas de la asignatura, se toma su tiempo para que sus estudiantes comprensan los temas, es una muy buena persona que reconoce el esfuerzo de sus estudiantes y los comprende.', '-Avisa y da ejemplos de ejercicios que saldran en el parcial. \r\n			-Siempre manda un parcial de repaso y son parciales que el aplicó anteriormente. \r\n			-Los porcentajes de las notas estan dados para que si se pierde es porque no hizo nada en todo el corte. \r\n			-Si hay dudas las reponde en el menor tiempo posible (dudas enviadas al correo).\r\n			-Se aprende bastante en sus clases.\r\n			-Siempre busca hacer sentir bien a sus entudiantes en las clases.\r\n			-Da muchas oportunidades para sacar buenas notas\r\n			-Durante los parciles el profesor responde a cualquier duda que tengan', '-Ninguna', '2024-03-18', 5, 5, 5, 5, 5, 5, 5, 5, 4, 1, 3),
(2, 2, 74, '2023-1', 'fue un excelente docente en el curso. Sus explicaciones eran claras y precisas,\r\n y siempre estaba dispuesto a responder preguntas', NULL, NULL, '2024-03-10', 4, 4, 5, 3, 4, 5, 4, 3, 3, 1, 1),
(2, 3, 83, '2023-1', 'Su metodologia deja que desear, los temas no son explicados con profundida y su manera de implementar la practica es pobre.', NULL, NULL, '2024-03-19', 3, 3, 4, 4, 4, 3, 3, 4, 3, 1, 2),
(2, 8, 72, '2024-1', 'una docente amable, capaz con muchos conocimientos y un sentido de ayuda hacia los estudiantes y en su progreso academico', 'amabilidad, atencion, pasciente, divertida.', 'un poquito impuntual', '2024-02-01', 5, 5, 4, 5, 3, 3, 5, 4, 4, 1, NULL),
(3, 2, 83, '2023-1', 'Una metodología profunda, Nelly se preocupa por que todos los estudiantes aprendan sin la necesidad de explicar el tema superficialmente', NULL, NULL, '2024-03-19', 5, 4, 4, 5, 3, 4, 4, 4, 5, 1, 1),
(3, 3, 13, '2024-1', 'Tiene una metodologia organizada y completa, es flexible con sus estudiantes, demuestra gran dominio del tema y los conceptos los desarrolla muy bien se abstraen con facilidad, pero los explica de corrido entonces puede ser un poco agotadora la clase.', '-Los parciales los hace en parejas o permite a sus estudiantes que escojan la metodologia del parcial', '-Usa muchas diapositivas y es dificil acceder a ese material', '2024-03-18', 5, 3, 5, 5, 5, 5, 5, 5, 3, 1, 3),
(3, 3, 50, '2023-1', 'El profesor aborda los temas con profundidad y se asegura de que todos los estudiantes comprendan completamente los conceptos.', 'Explica de manera clara y precisa', 'Las clases pueden extenderse más de lo planeado', '2024-03-20', 4, 5, 3, 4, 4, 5, 5, 4, 4, 3, 3),
(3, 4, 72, '2024-1', 'un docente amable y divertido, demas de didactico y pasciente a la hora de impartir sus enseñanzas', 'amabilidad, atencion, pasciente, divertido.', 'desvaria un poquito', '2024-02-01', 5, 5, 4, 5, 4, 4, 4, 4, 5, 1, NULL),
(3, 9, 127, '2023-3', 'Aunque tiene bastante conocimiento del tema la forma en la que lo explica deja bastante que desear, no recomiendo meterlo con el si realmente quieren aprender.', 'Tiene un buen dominio del tema', 'Forma de calificación injusta, poca profundización sobre la temática', '2024-03-18', 5, 4, 5, 3, 4, 4, 4, 3, 5, 1, 2),
(3, 9, 128, '2024-1', 'Dificil hasta que entiendes bien de POO y C++', NULL, NULL, '2024-03-18', 5, 3, 4, 5, 5, 5, 5, 5, 4, 1, 2),
(4, 1, 35, '2020', ' las clases son aburridas deberia mejorar y hacerlas mas dinamicas ', 'explica bien', 'su actitud ', '2022-06-01', 5, 3, 4, 3, 5, 3, 4, 4, 4, 1, 3),
(4, 3, 50, '2023-3', 'El profesor demuestra un profundo conocimiento en el área y proporciona muchos recursos para el aprendizaje autónomo.', 'Ofrece recursos de estudio adicionales', 'Puede ser un poco exigente en sus calificaciones', '2024-03-20', 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 3),
(4, 9, 1, '2023-2', 'Es un profesor muy amable, siempre mantiene una actitud positiva en la clase, y a pesar de que suele dar clases unicamente a las 6 de la mañana realmente no da sueño ni pereza ir a su clase ya que su forma de explicar es muy dinamica.', '- Siempre resuelve dudas - Se ve el interes por nuestro aprendizaje', '_', '2024-03-19', 5, 5, 4, 5, 5, 4, 5, 5, 3, 1, 3),
(4, 9, 2, '2023-3', 'Nelson es un profesor que sabe lo que hace. No usa diapositivas ni tampoco apuntes. Todo lo que comparte con la clase lo escribe en los tableros de forma clara, lo que demuestra muy buen dominio del tema. Desarrolla los programas en C++. Hay que ser autónomo y coger práctica haciendo los ejercicios propuestos. Hay que tener juicio con la puntualidad, es muy estricto con ella y se puede perder la materia fácilmente si no se asiste. Hay que cumplir con las tareas y NO usar ChatGTP porque él se da cuenta fácilmente si un estudiante hizo el programa o no. En general es muy buen profesor, enseña muy bien y es un poco exigente con las calificaciones', 'Ambiente agradable. Profesor tratable. Se aprende mucho. Deja reutilizar programas anteriormente desarrollados durante los parciales', 'Las clases el 90% son temprano. Es exigente calificando', '2024-03-19', 5, 5, 5, 5, 5, 5, 5, 3, 4, 1, 3),
(4, 9, 25, '2023-1', 'Es un buen profesor,su metodologia es buena, ademas, es claro en sus explicaciones y se aprende, si es cumplido con los trabajos pasa.', 'Siempre tiene muy buena actitud,responde todas las dudas y se le entiende', '', '2024-03-18', 5, 5, 5, 5, 5, 5, 5, 5, 4, 1, 2),
(4, 9, 30, '2024-1', 'excelente profesor dispuesto a ayudarte, facil de entender con explicaciones breves, muy atento a las dudas de los estudiantes', 'explica bien, toma el tiempo adecuado para cada tema', 'el horario de el va de 6am a 8am ya que debe ir a otras universidades', '2024-03-17', 5, 5, 4, 5, 5, 5, 5, 4, 3, 1, 3),
(4, 9, 78, '2', 'Es un profe muy bueno, explica bien es muy buena gente las clases son bastante dinamicas, en mi opinion de los mejores profespara esta materia', 'deja usar codigos previamente creados en los parciales', 'El horario del profe', '2023-08-10', 5, 5, 4, 5, 5, 3, 5, 5, 3, 1, NULL),
(4, 9, 110, '2024-1', 'El profesor Nelson es un experto en su campo. Sus clases son muy informativas, explica muy bien y siempre está dispuesto a responder preguntas', 'Es un profesor muy exigente, pero se aprende mucho en sus clases', 'exigente con las fallas por el horario que se maneja', '2024-03-19', 5, 5, 5, 5, 5, 5, 5, 5, 4, 1, 2),
(5, 10, 120, '2023-1', 'Es una profesora que exp1ica de manera conscisa pero fácil de entender, conoce mucho el tema y como docente es muy organizada y asimismo exige orden a sus estudiantes', NULL, NULL, '2024-04-08', 5, 5, 3, 5, 5, 4, 5, 5, 3, 1, NULL),
(7, 5, 50, '2024-1', 'Las clases son muy dinámicas y participativas, el profesor siempre está dispuesto a ayudar y aclarar dudas.', 'Enseña de manera muy práctica', 'Las evaluaciones pueden ser un poco difíciles', '2024-03-20', 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 3),
(7, 10, 1, '2023-2', 'Las clases suelen ser muy similares entre si, pero de vez en cuando el profesor invita a los estudiantes a realizar actividades culturales fuera de la universidad como forma de salir un poco de la rutina y aprender de otros entornos, siempre se presentan buenos temas de la actualidad del pais para debatir en clase', '- El material de apoyo como videos, peliculas y demas suele ser muy entretenido - Permite que los estudiantes aporten ideas y material para la clase', ' - A veces los temas de la clase se pueden extender mas de la cuenta, por lo que se puede volver un poco tediosa en ocasiones.', '2024-03-19', 4, 4, 1, 4, 5, 5, 4, 5, 1, 1, 3),
(7, 10, 20, '2022-1', 'El profesor llega a hablar sobre algun tema, al terminar acaba la clase y se va, suele no sacar notas ni tomar asistencia.', 'No es necesario dedicar mucho tiempo a esa materia.', 'Las clases se tornan aburridas y da sueño, No se comunica de la mejor manera.', '2024-03-15', 4, 2, 3, 3, 4, 1, 3, 3, 1, 1, 2),
(7, 10, 25, '2023-1', 'Es una buena clase, toca temas interesantes y es facil de pasar', 'Si asiste a todas las clases pasa', '', '2024-03-12', 5, 5, 1, 5, 5, 5, 5, 5, 1, 1, 3),
(7, 10, 30, '2024-1', 'clases donde la participacion de los estudiantes es minima, es facil pasar dado que solo tendra en cuenta tus asistencias', 'temas muy variados e interesantes', 'no tiene una metodologia para que los estudiantes participen como a el le gustaria', '2024-03-17', 5, 4, 3, 4, 4, 5, 4, 5, 3, 1, 2),
(7, 10, 74, '2023-1', 'un profesor en extremo politico, la clase constantemente se vuelve aburrida y tediosa', NULL, NULL, '2024-03-10', 3, 2, 2, 3, 1, 3, 1, 1, 2, 1, 2),
(7, 10, 110, '2024-1', 'Es una catedra que no suma mucho el profesor habla de los temas.', 'puede ser interesante, ya que se toma alguno temas importantes', 'No tengo ninguna queja.', '2024-03-19', 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 2),
(7, 10, 128, '2024-1', 'Se tiene muy en cuenta positivamente quien opina y pregunta en la clase. Muy importante estar atento al día del parcial ya que es la única nota', NULL, NULL, '2024-03-18', 5, 4, 3, 5, 5, 5, 5, 4, 3, 1, 2),
(8, 8, 128, '2024-1', 'Si se repasa en casa todo lo que expone en cada clase, se está bien preparado para sus parciales', NULL, NULL, '2024-03-18', 5, 4, 3, 5, 5, 5, 5, 5, 4, 1, 2),
(9, 5, 127, '2024-1', 'Es bastante sencillo pasar con él, la forma de explicar el tema, aunque no es la mejor, junto a los ejercicios que deja se puede complementar. No es exigente pero igual hay que prestar atención al tema.', 'No es tan exigente, completa la temática de la materia, es amable y atento con todos.', 'Es impuntual, es algo aburrida las clases teoricas.', '2024-03-18', 5, 3, 5, 5, 4, 4, 4, 4, 5, 1, NULL),
(10, 1, 35, '2020', ' Me parece que las clases de  el no son preparadas se pasa facil pero no aprende uno mucho,sus parciales son de preguntas con a,b y c ', 'explica con diapositivas', 'explica con afan ', '2022-06-01', 5, 2, 3, 5, 4, 3, 4, 4, 4, 1, 3),
(12, 3, 2, '2023-1', 'Es un profesor estricto pero sin generar miedo entre los estudiantes. Es muy buen pedagogo, sabe enseñar y darse a entender perfectamente. Requiere de trabajo autónomo pero el profesor siempre está ahí para guiar. Los parciales siempre son de acuerdo a lo que se ha visto en el curso. Hay que ser constante porque es una materia que requiere de práctica y tiempo. El profe Hermeth es el equilibrio entre ser buen profesor y buena persona, por eso lo recomiendo si se desea estar tranquilo pero sin miedo a no aprender lo suficiente', 'Talleres fáciles. Ambiente agradable. Profesor tratable y buena gente.', 'No deja sacar calculadoras en los parciales', '2024-03-19', 5, 5, 4, 5, 4, 5, 5, 4, 4, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `TipoContrato`
--

CREATE TABLE `TipoContrato` (
  `idTipoContrato` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TipoContrato`
--

INSERT INTO `TipoContrato` (`idTipoContrato`, `nombre`) VALUES
(1, 'Planta'),
(2, 'TCO'),
(3, 'MTO'),
(4, 'Catedra');

-- --------------------------------------------------------

--
-- Table structure for table `TipoCurso`
--

CREATE TABLE `TipoCurso` (
  `idTipoCurso` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TipoCurso`
--

INSERT INTO `TipoCurso` (`idTipoCurso`, `nombre`) VALUES
(1, 'Obligatorio Complementario'),
(2, 'Electiva Intrínseca'),
(3, 'Electiva Extrínseca'),
(4, 'Obligatorio Básico');

-- --------------------------------------------------------

--
-- Table structure for table `TipoDenuncia`
--

CREATE TABLE `TipoDenuncia` (
  `idTipoDenuncia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Votacion`
--

CREATE TABLE `Votacion` (
  `Referencia_Profesor_idProfesor` int(11) NOT NULL,
  `Referencia_Curso_idCurso` int(11) NOT NULL,
  `Referencia_Estudiante_idEstudiante` int(11) NOT NULL,
  `Referencia_periodo` varchar(45) NOT NULL,
  `Estudiante_idEstudiante` int(11) NOT NULL,
  `voto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Curso`
--
ALTER TABLE `Curso`
  ADD PRIMARY KEY (`idCurso`),
  ADD KEY `fk_Curso_TipoCurso1_idx` (`TipoCurso_idTipoCurso`),
  ADD KEY `fk_Curso_Programa1_idx` (`Programa_idPrograma`);

--
-- Indexes for table `Denuncia`
--
ALTER TABLE `Denuncia`
  ADD PRIMARY KEY (`Referencia_Profesor_idProfesor`,`Referencia_Curso_idCurso`,`Referencia_Estudiante_idEstudiante`,`Referencia_periodo`,`Estudiante_idEstudiante`),
  ADD KEY `fk_Denuncia_Estudiante1_idx` (`Estudiante_idEstudiante`),
  ADD KEY `fk_Denuncia_TipoDenuncia1_idx` (`TipoDenuncia_idTipoDenuncia`);

--
-- Indexes for table `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indexes for table `Facultad`
--
ALTER TABLE `Facultad`
  ADD PRIMARY KEY (`idFacultad`);

--
-- Indexes for table `Profesor`
--
ALTER TABLE `Profesor`
  ADD PRIMARY KEY (`idProfesor`,`TipoContrato_idTipoContrato`),
  ADD KEY `fk_Profesor_TipoContrato1_idx` (`TipoContrato_idTipoContrato`);

--
-- Indexes for table `Programa`
--
ALTER TABLE `Programa`
  ADD PRIMARY KEY (`idPrograma`,`Facultad_idFacultad`),
  ADD KEY `fk_Programa_Facultad1_idx` (`Facultad_idFacultad`);

--
-- Indexes for table `RangoNota`
--
ALTER TABLE `RangoNota`
  ADD PRIMARY KEY (`idRangoNota`);

--
-- Indexes for table `Referencia`
--
ALTER TABLE `Referencia`
  ADD PRIMARY KEY (`Profesor_idProfesor`,`Curso_idCurso`,`Estudiante_idEstudiante`,`periodo`),
  ADD KEY `fk_Referencia_Curso1_idx` (`Curso_idCurso`),
  ADD KEY `fk_Referencia_Estudiante1_idx` (`Estudiante_idEstudiante`),
  ADD KEY `fk_Referencia_RangoNota1_idx` (`RangoNota_idRangoNota`);

--
-- Indexes for table `TipoContrato`
--
ALTER TABLE `TipoContrato`
  ADD PRIMARY KEY (`idTipoContrato`);

--
-- Indexes for table `TipoCurso`
--
ALTER TABLE `TipoCurso`
  ADD PRIMARY KEY (`idTipoCurso`);

--
-- Indexes for table `TipoDenuncia`
--
ALTER TABLE `TipoDenuncia`
  ADD PRIMARY KEY (`idTipoDenuncia`);

--
-- Indexes for table `Votacion`
--
ALTER TABLE `Votacion`
  ADD PRIMARY KEY (`Referencia_Profesor_idProfesor`,`Referencia_Curso_idCurso`,`Referencia_Estudiante_idEstudiante`,`Referencia_periodo`,`Estudiante_idEstudiante`),
  ADD KEY `fk_Votacion_Estudiante1_idx` (`Estudiante_idEstudiante`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Curso`
--
ALTER TABLE `Curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `Facultad`
--
ALTER TABLE `Facultad`
  MODIFY `idFacultad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `Profesor`
--
ALTER TABLE `Profesor`
  MODIFY `idProfesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `Programa`
--
ALTER TABLE `Programa`
  MODIFY `idPrograma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `RangoNota`
--
ALTER TABLE `RangoNota`
  MODIFY `idRangoNota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `TipoContrato`
--
ALTER TABLE `TipoContrato`
  MODIFY `idTipoContrato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TipoCurso`
--
ALTER TABLE `TipoCurso`
  MODIFY `idTipoCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Curso`
--
ALTER TABLE `Curso`
  ADD CONSTRAINT `fk_Curso_Programa1` FOREIGN KEY (`Programa_idPrograma`) REFERENCES `Programa` (`idPrograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Curso_TipoCurso1` FOREIGN KEY (`TipoCurso_idTipoCurso`) REFERENCES `TipoCurso` (`idTipoCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Denuncia`
--
ALTER TABLE `Denuncia`
  ADD CONSTRAINT `fk_Denuncia_Estudiante1` FOREIGN KEY (`Estudiante_idEstudiante`) REFERENCES `Estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Denuncia_Referencia1` FOREIGN KEY (`Referencia_Profesor_idProfesor`,`Referencia_Curso_idCurso`,`Referencia_Estudiante_idEstudiante`,`Referencia_periodo`) REFERENCES `Referencia` (`Profesor_idProfesor`, `Curso_idCurso`, `Estudiante_idEstudiante`, `periodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Denuncia_TipoDenuncia1` FOREIGN KEY (`TipoDenuncia_idTipoDenuncia`) REFERENCES `TipoDenuncia` (`idTipoDenuncia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Profesor`
--
ALTER TABLE `Profesor`
  ADD CONSTRAINT `fk_Profesor_TipoContrato1` FOREIGN KEY (`TipoContrato_idTipoContrato`) REFERENCES `TipoContrato` (`idTipoContrato`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Programa`
--
ALTER TABLE `Programa`
  ADD CONSTRAINT `fk_Programa_Facultad1` FOREIGN KEY (`Facultad_idFacultad`) REFERENCES `Facultad` (`idFacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Referencia`
--
ALTER TABLE `Referencia`
  ADD CONSTRAINT `fk_Referencia_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `Curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Referencia_Estudiante1` FOREIGN KEY (`Estudiante_idEstudiante`) REFERENCES `Estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Referencia_Profesor1` FOREIGN KEY (`Profesor_idProfesor`) REFERENCES `Profesor` (`idProfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Referencia_RangoNota1` FOREIGN KEY (`RangoNota_idRangoNota`) REFERENCES `RangoNota` (`idRangoNota`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Votacion`
--
ALTER TABLE `Votacion`
  ADD CONSTRAINT `fk_Votacion_Estudiante1` FOREIGN KEY (`Estudiante_idEstudiante`) REFERENCES `Estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Votacion_Referencia1` FOREIGN KEY (`Referencia_Profesor_idProfesor`,`Referencia_Curso_idCurso`,`Referencia_Estudiante_idEstudiante`,`Referencia_periodo`) REFERENCES `Referencia` (`Profesor_idProfesor`, `Curso_idCurso`, `Estudiante_idEstudiante`, `periodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
