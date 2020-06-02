package es.uv.twcam.projects.airproject.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
*
* @author danilosalaz
*/
public class IEntityDAO {

	private String name;
	private List<MethodDAO> methods;
	private String typeEntity;
	
	public IEntityDAO() {
		methods = new ArrayList<IEntityDAO.MethodDAO>();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MethodDAO> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodDAO> methods) {
		this.methods = methods;
	}
	
	public void addMethod (String name, Map<String, String> arg, String retu) {
		methods.add(new MethodDAO(name,arg,retu));
	}
	
	
	@Override
	public String toString() {
		final StringBuilder methodString = new StringBuilder();
		methodString.append("{");
		methodString.append(this.getName() + ": {");
		methodString.append("\n");
		for(IEntityDAO.MethodDAO m: getMethods()) {
			if(m.getRetu() != null)
				methodString.append(" "+ m.getRetu() + " ");
			else
				methodString.append(" void ");
			methodString.append(m.getName() + "(");
			if(m.getArg() != null) {
				m.getArg().forEach((k,v) -> {
					methodString.append(v + " " + k + ", ");
				});
				methodString.delete(methodString.length() - 2, methodString.length());
				
				
			}
			methodString.append("), \n");
			
			
		};
		methodString.delete(methodString.length() - 3, methodString.length());
		methodString.append("\n");
		methodString.append(" }");
		methodString.append("\n");
		methodString.append("}");
		return methodString.toString();
	}


	public String getTypeEntity() {
		return typeEntity;
	}

	public void setTypeEntity(String typeEntity) {
		this.typeEntity = typeEntity;
	}


	public class MethodDAO {

		private String name;
		private Map<String, String> arg;
		private String retu;
		
		
		public MethodDAO() {
			
		}
		public MethodDAO(String name, Map<String, String> arg, String retu) {
			super();
			this.retu = retu;
			this.arg = arg;
			this.name = name;
		}

		public String getRetu() {
			return retu;
		}

		public void setRetu(String retu) {
			this.retu = retu;
		}

		public Map<String, String> getArg() {
			return arg;
		}

		public void setArg(Map<String, String> arg) {
			this.arg = arg;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
