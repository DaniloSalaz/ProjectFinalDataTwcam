package es.uv.twcam.projects.airproject.Utils;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/**
*
* @author danilosalaz
*/
public class CodeGenerator {
	
	public static void createInterfaceDao(PrintWriter pw, IEntityDAO entity) {
		try {
			pw.println("package es.uv.twcam.projects.airproject.service;\n");
			pw.println("import java.util.List;\n");
			pw.println("import es.uv.twcam.projects.airproject.entity." + entity.getTypeEntity() + ";\n");
			
			pw.println("public interface I" + entity.getName() + " {\n");
			
			pw.println(createMethods(entity,false));

			pw.print("}");
			
			pw.flush();
			pw.close();
		}catch(Exception e){
			System.err.println("Error al crear interface: " + e.getMessage());
		}
	}
	public static void createEntityDaoImpl(PrintWriter pw, IEntityDAO entity) {
		pw.println("package es.uv.twcam.projects.airproject.service;\n");
		pw.println("import java.util.List;\n");
		pw.println("import javax.persistence.EntityManager;\n");
		pw.println("import es.uv.twcam.projects.airproject.entity." + entity.getTypeEntity() + ";");
		pw.println("import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;\n");
		
		pw.println("public class " + entity.getName() + "Impl " + 
		"extends DataDAOImpl<Integer,"+ entity.getTypeEntity() + ">" + " implements I" + entity.getName() + " {\n");
		
		pw.println("\t" + "public " + entity.getName() + "Impl(EntityManager em) {");
		pw.println("\t\t"+ "super(em, " + entity.getTypeEntity() + ".class);");
		pw.println("\t" + "}\n");
		
		pw.println(createMethods(entity,true));
		
		pw.print("}");
		
		pw.flush();
		pw.close();
		
		
	} 
	public static void createDAOFactory(PrintWriter pw, List<IEntityDAO> entitys) {
		pw.println("package es.uv.twcam.projects.airproject.repositoryDAO;\n");
		
		for(IEntityDAO en: entitys)
			pw.println("import es.uv.twcam.projects.airproject.service.I" + en.getName() + ";");
		pw.println("\n" + "public abstract class DataDAOFactory {\n");
		
		pw.println("\t" + "public enum TYPE{JPA,XML}\n");
		
		for(IEntityDAO en: entitys)
			pw.println("\t" + "public abstract I" + en.getName() + " get" + en.getName() + "();\n");
		
		pw.println("\t" + "public static DataDAOFactory getDAOFactory(TYPE t) {");
		pw.println("\t\t" + "switch(t) {");
		pw.println("\t\t\t" + "case JPA:");
		pw.println("\t\t\t\t" + "return new JPADAOFactory();");
		pw.println("\t\t\t" + "default:");
		pw.println("\t\t\t\t" + "break;");
		pw.println("\t\t" + "}");
		pw.println("\t\t" + "return null;");
		
		pw.println("\t" + "}");
		pw.println("}");
		
		pw.flush();
		pw.close();
	}
	public static void createJPADAOFactory(PrintWriter pw, List<IEntityDAO> entitys) {
		pw.println("package es.uv.twcam.projects.airproject.repositoryDAO;\n");
		
		pw.println("import javax.persistence.EntityManager;");
		pw.println("import javax.persistence.EntityManagerFactory;");
		pw.println("import javax.persistence.Persistence;\n");
		
		for(IEntityDAO en: entitys) {
			pw.println("import es.uv.twcam.projects.airproject.service." + en.getName() + "Impl;");
			pw.println("import es.uv.twcam.projects.airproject.service.I" + en.getName() + ";");
		}
		
		pw.println("\n public class JPADAOFactory extends DataDAOFactory {\n");
		pw.println("\t" + "private EntityManager getEntityManager() {");
		pw.println("\t\t" + "EntityManagerFactory emf = Persistence.createEntityManagerFactory(\"acmeAeropuerto\");");
		pw.println("\t\t" + "return emf.createEntityManager();");
		pw.println("\t\t" + "}\n");
		
		for(IEntityDAO en: entitys) {
			pw.println("\t" + "@Override");
			pw.println("\t" + "public I" + en.getName() + " get" + en.getName() +"() {");
			pw.println("\t\t" + "return new " + en.getName() + "Impl(getEntityManager());");
			pw.println("\t" + "}\n");
		}
		
		pw.println("}");
		
		pw.flush();
		pw.close();
	}
	public static String createMethods(IEntityDAO entity, boolean isImplementation) {
		StringBuilder resMethods = new StringBuilder();
		
		for(IEntityDAO.MethodDAO m: entity.getMethods()) {
			if(isImplementation)
				resMethods.append("\t" + "@Override\n");
			resMethods.append("\t" + "public ");
			
			if(m.getRetu() != null)
				resMethods.append(m.getRetu() + " ");
			else
				resMethods.append("void ");
			resMethods.append(m.getName() + "(");
			
			AtomicInteger count = new AtomicInteger();
			
			if(m.getArg() != null) {
				for(Map.Entry<String, String> ar: m.getArg().entrySet()) {
					resMethods.append(ar.getValue() + " " + ar.getKey() );
					if(m.getArg().size() -1 != count.getAndIncrement())
						resMethods.append(",");
				}
			}
			if(isImplementation) {
				resMethods.append(") {\n");
				resMethods.append("\t\t" + impleMethods(m.getName(),entity.getTypeEntity(), m.getRetu()) + "\n");
				resMethods.append("\t" + "}\n");
			}else
				resMethods.append(");\n\n");
				
		}
		
		return resMethods.toString();
	}
	
	public static String impleMethods(String nameMethod, String typeEntity,  String retu) {
		String resImpl = "";
		if(nameMethod.equals("get" + typeEntity + "s"))
			resImpl = "return this.findAll();";
		else if(nameMethod.equals("get" + typeEntity))
			resImpl = "return this.findById(id);";
		else if(nameMethod.equals("create" + typeEntity))
			resImpl = "this.create(" + typeEntity.toLowerCase() + ");";
		else if(nameMethod.equals("update"+ typeEntity))
			resImpl = "this.update(" + typeEntity.toLowerCase() + ");";
		else if(nameMethod.equals("delete" + typeEntity))
			resImpl = "this.delete(" + typeEntity.toLowerCase() + ");";
		else if(nameMethod.equals("deleteById")) {
			resImpl = typeEntity + " " + typeEntity.toLowerCase() + " = this." + "get" + typeEntity + "(id);\n";
			resImpl += "if(" + typeEntity.toLowerCase() + "!= null)\n";
			resImpl += "\t" + "this.delete(" + typeEntity.toLowerCase() + ");\n";
			resImpl += "else\n";
			resImpl += "\t" + "System.out.println(\"" + typeEntity + "no encontrado, no se pudo borrar\");";
		}else { 
			resImpl = "// TODO Auto-generated method stub \n";
			if(retu != null)
				resImpl += "\t\t"+ "return null;";
		}
		
		return resImpl;
	}


	
	
	
}
