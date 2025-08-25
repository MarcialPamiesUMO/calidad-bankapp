# 📘 README – Práctica de SonarQube/SonarLint con `calidad-bankapp`

## 🎯 Objetivos de aprendizaje

- Analizar un proyecto Java (Maven, JDK 11) con **SonarQube for IDE** (Eclipse 2021‑12) y **SonarQube/SonarCloud**.
- Identificar *code smells*, *bugs* y *vulnerabilidades* típicas.
- **Corregir en código**: recursos sin cerrar, logging, manejo de excepciones y secretos en claro.
- **Desactivar** una regla para el proyecto: `java:S1147` (uso deliberado de `System.exit` en CLI).
- **Modificar/configurar** una regla: `java:S2077` (SQL injection) añadiendo un *sanitizer* propio.

## 🧱 Requisitos

- Java 17 (JDK)
- Maven 3.6+
- Eclipse IDE 2021‑12 (4.22.0)
- Plugin del IDE: **SonarQube for IDE (formerly SonarLint)**
- (Opcional) Un servidor **SonarQube** local o **SonarCloud** (Cloud)

## 📦 Estructura del proyecto

```
calidad-bankapp/
├─ pom.xml
└─ src/main/java/com/example/bank/
   ├─ Main.java
   ├─ BankService.java
   ├─ UserRepository.java
   └─ Utils.java
```

## 🚀 Importar en Eclipse

1) **File > Import… > Maven > Existing Maven Projects** → elige la carpeta.
2) **JDK 11**: *Project > Properties > Java Compiler* (11).
3) Instala **SonarQube for IDE** desde *Eclipse Marketplace* (aparece como *formerly SonarLint*).
4) (Opcional) Vincula tu proyecto al servidor SonarQube/SonarCloud para usar su **Quality Profile**.

## 🔎 Issues esperados (estado inicial)

- `java:S2068` – Credenciales en claro (`Main.dbPassword`).
- `java:S1147` – Uso de `System.exit` (queremos **desactivarla** en el perfil del proyecto, por tratarse de una CLI).
- `java:S106` – `System.out` en lugar de logger.
- `java:S1166` – `catch` sin manejo.
- `java:S2095` – Recursos JDBC no cerrados.
- `java:S2077` – SQL injection (concatenación).

## 🛠️ Sugerencias de corrección

- *try-with-resources* en JDBC.
- Sustituir `System.out` por `java.util.logging`.
- Manejar y/o repropagar excepciones.
- Usar variables de entorno para secretos.
- (Mejor práctica) `PreparedStatement` en lugar de concatenación para SQL.
