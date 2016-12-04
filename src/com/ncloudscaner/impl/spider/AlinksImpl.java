package com.ncloudscaner.impl.spider;

import com.ncloudscaner.domains.LinksTree;

public class AlinksImpl {
	private LinksTree tree;
	public void  setTree(LinksTree Tree){
		this.tree  = Tree;
	}
	public LinksTree getTree(){
		return tree;
	}
	public boolean setUrl(String Url){
		try{
			String url = Url;
			String urls;
			if((url.startsWith("http:"))||url.startsWith("https:")){
				urls = url.substring(url.indexOf("://")+3);
				if(!urls.contains("/")){
					url+="/";
					tree.setTreeRoot(url);
					tree.setRightNode("");
				}
				else if((urls.split("/").length<2)){
					tree.setTreeRoot(url);
					tree.setRightNode("");
					System.out.println(tree.getTreeRoot());
				}
				else if(url.endsWith("/")){
					tree.setTreeRoot(url);
					tree.setRightNode("");
					
				}
				else{
					String[] sp =urls.split("/");
					url="";
					for(int a=0;a<=sp.length-2;a++){
						url=url+sp[a]+"/";
					}
					url = Url.substring(0,Url.indexOf("://")+3)+url;
					tree.setTreeRoot(url);
					tree.setRightNode(sp[sp.length-1]);
				}
			}
			else if(url.startsWith("../")){
				
				String  treeRoot = tree.getTreeRoot().substring(tree.getTreeRoot().indexOf("://")+3,tree.getTreeRoot().length())+"ext";
				//System.out.println(tree.getTreeRoot().substring(tree.getTreeRoot().indexOf("://")+3,tree.getTreeRoot().length()));
				String[] sp = treeRoot.split("/");
				String root = "";
				for(int i=0;i<=sp.length-3;i++){
					root+=sp[i]+"/";
				}
				
				root=tree.getTreeRoot().substring(0,tree.getTreeRoot().indexOf("://")+3)+root;
				tree.setTreeRoot(root);
				tree.setRightNode(url.substring(3));
			}
			else{
				tree.setRightNode(url.replaceAll("./", ""));
			}
			return  true;
		}catch(Exception e){
			return false;
		}
			
	}
	public void start(){
		
	}
}
