package com.yangfuzhao.common.constant;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;


public class PathUtil {
    
    private static Logger logger = Logger.getLogger(PathUtil.class);
    
	private static String defaultClassPathDir = null;
	
	
	
	/**
	 * 获取Jar包所在路径,如果是eclipse里面启动则获取target目录所在路径
	 * @return
	 */
	public static String getJarOrTargetPath(Class<?> cls){
	    String jarPath = PathUtil.getPathFromClass(cls);
        if(jarPath.indexOf("target")!=-1){
            return jarPath.substring(0,jarPath.indexOf("target"));
        }else{
            if(!jarPath.endsWith("jar")){
                return null;
            }
            return jarPath.substring(0,jarPath.lastIndexOf(File.separator))+File.separator;
        }
	}
	
	/**
     * 获取一个类的classPath路径(或所在jar包的绝对路径)
     * 
     */
	public static String getDefaultClassPathDir(Class<?> cls){
		if(defaultClassPathDir == null){
			if(defaultClassPathDir == null || defaultClassPathDir.trim().equals("")){
				String jarOrClass_Path = getPathFromClass(cls);
				if(jarOrClass_Path.endsWith("jar")){
				    defaultClassPathDir = jarOrClass_Path.substring(0,jarOrClass_Path.lastIndexOf("\\"))+"\\";
				}else{
				    defaultClassPathDir = jarOrClass_Path.substring(0,jarOrClass_Path.lastIndexOf("classes"))+"classes\\";
				}
			}
		}
		return defaultClassPathDir;
	}
	
	
	
	
	/**
     * 获取一个类的class文件所在的绝对路径(或所在jar包的绝对路径)
     * 
     * @cls 传入的类
     * @return 所在的绝对路径
     */
	public static String getPathFromClass(Class<?> cls)
	{
		String path = null;
		URL url = getClassLocationURL(cls);
		if (url != null)
		{
			path = url.getPath();
			if ("jar".equalsIgnoreCase(url.getProtocol()))
			{
				try
				{
					path = new URL(path).getPath();
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				int location = path.indexOf("!/");
				if (location != -1)
				{
					path = path.substring(0, location);
				}
			}
			File file = new File(path);
			try{
				path = file.getCanonicalPath();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return path;
	}
	
	
	/**
     * 通过与某个class文件的相对路径来获取文件或目录的绝对路径
     * 
     * @relatedPath 相对路径
     * @cls 传入的类
     * @return 相对路径所对应的绝对路径
     */
    public static String getPathFromClass(String relatedPath, Class<?> cls){
        String path = null;
        String clsPath = getPathFromClass(cls);
        File clsFile = new File(clsPath);
        String tempPath = clsFile.getParent() + File.separator + relatedPath;
        File file = new File(tempPath);
        try{
            path = file.getCanonicalPath();
        }catch(IOException e){
            logger.error(e);
        }
        return path;
    }
	
	private static URL getClassLocationURL(final Class<?> cls)
	{
		if (cls == null)
			throw new IllegalArgumentException("null input: cls");
		URL result = null;
		final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
		final ProtectionDomain pd = cls.getProtectionDomain();
		if (pd != null)
		{
			final CodeSource cs = pd.getCodeSource();
			if (cs != null)
				result = cs.getLocation();

			if (result != null)
			{
				if ("file".equals(result.getProtocol()))
				{
					try
					{
						if (result.toExternalForm().endsWith(".jar")
										|| result.toExternalForm().endsWith(
														".zip"))
							result = new URL("jar:".concat(
											result.toExternalForm()).concat(
											"!/").concat(clsAsResource));
						else if (new File(result.getFile()).isDirectory())
							result = new URL(result, clsAsResource);
					}
					catch (MalformedURLException ignore)
					{
						ignore.printStackTrace();
					}
				}
			}
		}

		if (result == null)

		{
			final ClassLoader clsLoader = cls.getClassLoader();
			result = clsLoader != null ? clsLoader.getResource(clsAsResource)
							: ClassLoader.getSystemResource(clsAsResource);
		}
		return result;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args){
	    String s = PathUtil.getPathFromClass(java.util.Date.class);
        String ralations = PathUtil.getPathFromClass("../../",java.util.Date.class);
        String s1 = PathUtil.getPathFromClass(PathUtil.class);
        String s2 = PathUtil.getPathFromClass(org.apache.commons.collections4.BidiMap.class);
        String ralations2 = PathUtil.getPathFromClass("../../",org.apache.commons.collections4.BidiMap.class);
        System.out.println(s+ "  " + ralations);
        System.out.println(s1);
        System.out.println(s2+ "  " + ralations2);
        
	}
}