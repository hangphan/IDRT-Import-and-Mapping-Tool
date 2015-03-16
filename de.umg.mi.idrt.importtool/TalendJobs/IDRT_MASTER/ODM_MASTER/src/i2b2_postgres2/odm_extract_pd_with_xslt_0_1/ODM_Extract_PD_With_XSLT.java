// ============================================================================
//
// Copyright (c) 2006-2014, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Data Integration
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package i2b2_postgres2.odm_extract_pd_with_xslt_0_1;

import routines.IIT;
import routines.Mathematical;
import routines.DataOperation;
import routines.Relational;
import routines.TalendDate;
import routines.TalendDataGenerator;
import routines.Numeric;
import routines.TalendString;
import routines.StringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")
/**
 * Job: ODM_Extract_PD_With_XSLT Purpose: <br>
 * Description:  <br>
 * @author test@talend.com
 * @version 5.6.1.20141207_1530
 * @status 
 */
public class ODM_Extract_PD_With_XSLT implements TalendJob {

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends java.util.Properties {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (folderMain != null) {

				this.setProperty("folderMain", folderMain.toString());

			}

			if (folderTmp != null) {

				this.setProperty("folderTmp", folderTmp.toString());

			}

			if (currentFile != null) {

				this.setProperty("currentFile", currentFile.toString());

			}

			if (xslt != null) {

				this.setProperty("xslt", xslt.toString());

			}

			if (output != null) {

				this.setProperty("output", output.toString());

			}

			if (xslt_namespace != null) {

				this.setProperty("xslt_namespace", xslt_namespace.toString());

			}

		}

		public String folderMain;

		public String getFolderMain() {
			return this.folderMain;
		}

		public String folderTmp;

		public String getFolderTmp() {
			return this.folderTmp;
		}

		public String currentFile;

		public String getCurrentFile() {
			return this.currentFile;
		}

		public String xslt;

		public String getXslt() {
			return this.xslt;
		}

		public String output;

		public String getOutput() {
			return this.output;
		}

		public String xslt_namespace;

		public String getXslt_namespace() {
			return this.xslt_namespace;
		}
	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ODM_Extract_PD_With_XSLT";
	private final String projectName = "I2B2_POSTGRES2";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	public boolean isExportedAsOSGI = false;

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private java.lang.Exception exception = null;

	public java.lang.Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends java.lang.Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private java.lang.Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(java.lang.Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public java.lang.Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(java.lang.Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err
						.println("Exception in component " + currentComponent);
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					ODM_Extract_PD_With_XSLT.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ODM_Extract_PD_With_XSLT.this,
									new Object[] { e, currentComponent,
											globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (java.lang.SecurityException e) {
					this.e.printStackTrace();
				} catch (java.lang.IllegalArgumentException e) {
					this.e.printStackTrace();
				} catch (java.lang.IllegalAccessException e) {
					this.e.printStackTrace();
				} catch (java.lang.reflect.InvocationTargetException e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tJava_1_error(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJava_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXSLT_2_error(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tXSLT_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXSLT_1_error(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tXSLT_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_onSubJobError(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tXSLT_2_onSubJobError(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tXSLT_1_onSubJobError(java.lang.Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJava_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				/**
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				int tos_count_tJava_1 = 0;

				System.out.println("Extracting Patient Data (XSLT)");
				System.out.println("for " + context.currentFile);

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tJava_1 main ] start
				 */

				currentComponent = "tJava_1";

				tos_count_tJava_1++;

				/**
				 * [tJava_1 main ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				/**
				 * [tJava_1 end ] stop
				 */
			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT",
						"CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk", "", Thread
								.currentThread().getId() + "", "", "", "", "",
						"");
			}

			tXSLT_2Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}

	public void tXSLT_2Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tXSLT_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				/**
				 * [tXSLT_2 begin ] start
				 */

				ok_Hash.put("tXSLT_2", false);
				start_Hash.put("tXSLT_2", System.currentTimeMillis());

				currentComponent = "tXSLT_2";

				int tos_count_tXSLT_2 = 0;

				/**
				 * [tXSLT_2 begin ] stop
				 */

				/**
				 * [tXSLT_2 main ] start
				 */

				currentComponent = "tXSLT_2";

				System.setProperty("javax.xml.transform.TransformerFactory",
						"net.sf.saxon.TransformerFactoryImpl");

				java.io.File xsltFiletXSLT_2 = new java.io.File(
						context.folderMain + context.xslt_namespace);
				javax.xml.transform.stream.StreamSource styleSourcetXSLT_2 = new javax.xml.transform.stream.StreamSource(
						xsltFiletXSLT_2);
				javax.xml.transform.Transformer ttXSLT_2 = javax.xml.transform.TransformerFactory
						.newInstance().newTransformer(styleSourcetXSLT_2);

				javax.xml.transform.stream.StreamSource xmlSourcetXSLT_2 = new javax.xml.transform.stream.StreamSource(
						new java.io.File(context.currentFile));
				ttXSLT_2.transform(
						xmlSourcetXSLT_2,
						new javax.xml.transform.stream.StreamResult(
								new java.io.File(context.folderMain
										+ context.output + "no_namespaces.xml")));

				if ((context.folderMain + context.output + "no_namespaces.xml")
						.indexOf("/") != -1) {
					globalMap
							.put("tXSLT_2_OUTPUT_FILEPATH",
									(context.folderMain + context.output + "no_namespaces.xml")
											.substring(
													0,
													(context.folderMain
															+ context.output + "no_namespaces.xml")
															.lastIndexOf("/")));
					globalMap
							.put("tXSLT_2_OUTPUT_FILENAME",
									(context.folderMain + context.output + "no_namespaces.xml")
											.substring((context.folderMain
													+ context.output + "no_namespaces.xml")
													.lastIndexOf("/") + 1));
				} else {
					globalMap.put("tXSLT_2_OUTPUT_FILEPATH", context.folderMain
							+ context.output + "no_namespaces.xml");
					globalMap.put("tXSLT_2_OUTPUT_FILENAME", context.folderMain
							+ context.output + "no_namespaces.xml");
				}

				tos_count_tXSLT_2++;

				/**
				 * [tXSLT_2 main ] stop
				 */

				/**
				 * [tXSLT_2 end ] start
				 */

				currentComponent = "tXSLT_2";

				ok_Hash.put("tXSLT_2", true);
				end_Hash.put("tXSLT_2", System.currentTimeMillis());

				/**
				 * [tXSLT_2 end ] stop
				 */
			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT",
						"CONNECTION:SUBJOB_OK:tXSLT_2:OnSubjobOk", "", Thread
								.currentThread().getId() + "", "", "", "", "",
						"");
			}

			tXSLT_1Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tXSLT_2 finally ] start
				 */

				currentComponent = "tXSLT_2";

				/**
				 * [tXSLT_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tXSLT_2_SUBPROCESS_STATE", 1);
	}

	public void tXSLT_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tXSLT_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				/**
				 * [tXSLT_1 begin ] start
				 */

				ok_Hash.put("tXSLT_1", false);
				start_Hash.put("tXSLT_1", System.currentTimeMillis());

				currentComponent = "tXSLT_1";

				int tos_count_tXSLT_1 = 0;

				/**
				 * [tXSLT_1 begin ] stop
				 */

				/**
				 * [tXSLT_1 main ] start
				 */

				currentComponent = "tXSLT_1";

				System.setProperty("javax.xml.transform.TransformerFactory",
						"net.sf.saxon.TransformerFactoryImpl");

				java.io.File xsltFiletXSLT_1 = new java.io.File(
						context.folderMain + context.xslt);
				javax.xml.transform.stream.StreamSource styleSourcetXSLT_1 = new javax.xml.transform.stream.StreamSource(
						xsltFiletXSLT_1);
				javax.xml.transform.Transformer ttXSLT_1 = javax.xml.transform.TransformerFactory
						.newInstance().newTransformer(styleSourcetXSLT_1);

				javax.xml.transform.stream.StreamSource xmlSourcetXSLT_1 = new javax.xml.transform.stream.StreamSource(
						new java.io.File(context.folderMain + context.output
								+ "no_namespaces.xml"));
				ttXSLT_1.transform(xmlSourcetXSLT_1,
						new javax.xml.transform.stream.StreamResult(
								new java.io.File(context.folderMain
										+ context.output + "Only_PD.xml")));

				if ((context.folderMain + context.output + "Only_PD.xml")
						.indexOf("/") != -1) {
					globalMap
							.put("tXSLT_1_OUTPUT_FILEPATH",
									(context.folderMain + context.output + "Only_PD.xml")
											.substring(
													0,
													(context.folderMain
															+ context.output + "Only_PD.xml")
															.lastIndexOf("/")));
					globalMap
							.put("tXSLT_1_OUTPUT_FILENAME", (context.folderMain
									+ context.output + "Only_PD.xml")
									.substring((context.folderMain
											+ context.output + "Only_PD.xml")
											.lastIndexOf("/") + 1));
				} else {
					globalMap.put("tXSLT_1_OUTPUT_FILEPATH", context.folderMain
							+ context.output + "Only_PD.xml");
					globalMap.put("tXSLT_1_OUTPUT_FILENAME", context.folderMain
							+ context.output + "Only_PD.xml");
				}

				tos_count_tXSLT_1++;

				/**
				 * [tXSLT_1 main ] stop
				 */

				/**
				 * [tXSLT_1 end ] start
				 */

				currentComponent = "tXSLT_1";

				ok_Hash.put("tXSLT_1", true);
				end_Hash.put("tXSLT_1", System.currentTimeMillis());

				/**
				 * [tXSLT_1 end ] stop
				 */
			}// end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tXSLT_1 finally ] start
				 */

				currentComponent = "tXSLT_1";

				/**
				 * [tXSLT_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tXSLT_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private java.util.Properties context_param = new java.util.Properties();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final ODM_Extract_PD_With_XSLT ODM_Extract_PD_With_XSLTClass = new ODM_Extract_PD_With_XSLT();

		int exitCode = ODM_Extract_PD_With_XSLTClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = ODM_Extract_PD_With_XSLT.class
					.getClassLoader().getResourceAsStream(
							"i2b2_postgres2/odm_extract_pd_with_xslt_0_1/contexts/"
									+ contextStr + ".properties");
			if (isDefaultContext && inContext == null) {

			} else {
				if (inContext != null) {
					// defaultProps is in order to keep the original context
					// value
					defaultProps.load(inContext);
					inContext.close();
					context = new ContextProperties(defaultProps);
				} else {
					// print info and job continue to run, for case:
					// context_param is not empty.
					System.err.println("Could not find the context "
							+ contextStr);
				}
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
			}
			context.folderMain = (String) context.getProperty("folderMain");
			context.folderTmp = (String) context.getProperty("folderTmp");
			context.currentFile = (String) context.getProperty("currentFile");
			context.xslt = (String) context.getProperty("xslt");
			context.output = (String) context.getProperty("output");
			context.xslt_namespace = (String) context
					.getProperty("xslt_namespace");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("folderMain")) {
				context.folderMain = (String) parentContextMap
						.get("folderMain");
			}
			if (parentContextMap.containsKey("folderTmp")) {
				context.folderTmp = (String) parentContextMap.get("folderTmp");
			}
			if (parentContextMap.containsKey("currentFile")) {
				context.currentFile = (String) parentContextMap
						.get("currentFile");
			}
			if (parentContextMap.containsKey("xslt")) {
				context.xslt = (String) parentContextMap.get("xslt");
			}
			if (parentContextMap.containsKey("output")) {
				context.output = (String) parentContextMap.get("output");
			}
			if (parentContextMap.containsKey("xslt_namespace")) {
				context.xslt_namespace = (String) parentContextMap
						.get("xslt_namespace");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tJava_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tJava_1) {
			globalMap.put("tJava_1_SUBPROCESS_STATE", -1);

			e_tJava_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out
					.println((endUsedMemory - startUsedMemory)
							+ " bytes memory increase when running : ODM_Extract_PD_With_XSLT");
		}

		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 32104 characters generated by Talend Open Studio for Data Integration on the
 * March 11, 2015 1:17:35 PM CET
 ************************************************************************************************/
