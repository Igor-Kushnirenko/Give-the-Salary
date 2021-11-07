abstract class Employee(
    var fullName: String,
    var experience: Int,
    var baseSalary: Double
) {
    open fun giveSalary(): Double {
        if (experience > 2 && experience < 5 ) return baseSalary + 200.0
        if (experience > 5) return baseSalary * 1.2 + 500.0
        return baseSalary
    }
    
}
class Developer(
    fullName: String,
    experience: Int,
    baseSalary: Double
) : Employee(fullName, experience, baseSalary)
class Designer(
    fullName: String,
    experience: Int,
    baseSalary: Double,
    var coeficient: Double
) : Employee(fullName, experience, baseSalary) {
    override fun giveSalary(): Double {
        
        return super.giveSalary() * coeficient
    }
}
class Manager(
    fullName: String,
    experience: Int,
    baseSalary: Double,
    var team: MutableList<Employee> = mutableListOf()
) : Employee(fullName, experience, baseSalary) {
    override fun giveSalary(): Double {
        var DevCount = team.filterIsInstance<Developer>().count()
        var DesCount = team.filterIsInstance<Designer>().count()
        var TeamCount =  DesCount + DevCount
        if (TeamCount > 5 && TeamCount < 10)  return super.giveSalary() + 200.0
        if (TeamCount > 10) return super.giveSalary() + 300.0
        if (DevCount > TeamCount/2) return super.giveSalary() * 1.1
        return super.giveSalary()
    }
}
class Department(
    var managers: MutableList<Manager> = mutableListOf()
) {
    fun giveAllSalary() {
        managers.forEach{manager -> manager.giveSalary()
        manager.team.forEach{employee -> employee.giveSalary()
                }
            }
        }
    }

fun main() {
    val manager1 = Manager("Tiffany Burns", 1, 500.0)
    val dev1 = Developer("Jamie Smith", 5, 250.0)
    manager1.team.add(dev1)
    val dev2 = Developer("John Adams", 4,250.0)
    manager1.team.add(dev2)
    val dev3 = Developer("Betty Washington", 8, 250.0)
    manager1.team.add(dev3)
    val dev4 = Developer("Kenneth Jackson", 2, 250.0)
    manager1.team.add(dev4)
    val des1 = Designer("Michael Daniels", 12, 200.0, 0.83)
    manager1.team.add(des1)
    val manager2 = Manager("Diane West", 6, 500.0)
    val dev5 = Developer("Billie Sanders", 1,250.0)
    manager2.team.add(dev5)
    val dev6 = Developer("Joseph Wright", 30, 250.0)
    manager2.team.add(dev6)
    val dev7 = Developer("Mary Townsend", 15, 250.0)
    manager2.team.add(dev7)
    val des2 = Designer("Nancy Clark", 4, 200.0, 0.6)
    manager2.team.add(des2)
    val des3 = Designer("Nicholas Murphy", 3, 200.0, 0.57)
    manager2.team.add(des3)
    val des4 = Designer("Andrey Leonard", 5, 200.0, 0.24)
    manager2.team.add(des4)
    val department = Department()
    department.giveAllSalary()
    println(dev1.fullName + " got salary: " + dev1.giveSalary())
    println(dev2.fullName + " got salary: " + dev2.giveSalary())
    println(dev3.fullName + " got salary: " + dev3.giveSalary())
    println(dev4.fullName + " got salary: " + dev4.giveSalary())
    println(dev5.fullName + " got salary: " + dev5.giveSalary())
    println(dev6.fullName + " got salary: " + dev6.giveSalary())
    println(dev7.fullName + " got salary: " + dev7.giveSalary())
    println(des1.fullName + " got salary: " + des1.giveSalary())
    println(des2.fullName + " got salary: " + des2.giveSalary())
    println(des3.fullName + " got salary: " + des3.giveSalary())
    println(des4.fullName + " got salary: " + des4.giveSalary())
    println(manager1.fullName + " got salary: " + manager1.giveSalary())
    println(manager2.fullName + " got salary: " + manager2.giveSalary())
}