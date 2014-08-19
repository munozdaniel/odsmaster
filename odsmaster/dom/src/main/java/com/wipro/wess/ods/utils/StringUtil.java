package com.wipro.wess.ods.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class StringUtil
{
  public static final String EMPTY_STRING = "";

  public static String convertStackTrace(Throwable t)
  {
    StringWriter s = new StringWriter();
    PrintWriter p = new PrintWriter(s);
    t.printStackTrace(p);
    String str = s.toString();
    str = str.replace('\t', ' ');
    str = str.replace('\r', ' ');

    return str;
  }

  public static boolean objectsAreEmptyStrings(Object obj1, Object obj2)
  {
    if ((((obj1 instanceof String) || (obj1 == null))) && (((obj2 instanceof String) || (obj2 == null)))) {
      if ((obj1 != null) && (obj2 != null) && 
        (containsOnlyWhitespaces((String)obj1)) && (containsOnlyWhitespaces((String)obj2))) {
        return (((String)obj1).length() == ((String)obj2).length());
      }

      return ((isEmpty((String)obj1)) && (isEmpty((String)obj2)));
    }
    return false;
  }

  public static boolean containsOnlyWhitespaces(String string)
  {
    if (string != null) {
      for (int i = 0; i < string.length(); ++i) {
        if (!(Character.isWhitespace(string.charAt(i)))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static boolean containsWhitespace(String string)
  {
    if (string != null) {
      for (int i = 0; i < string.length(); ++i) {
        if (Character.isWhitespace(string.charAt(i))) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isEmpty(String string)
  {
    boolean returnValue = true;
    if ((string != null) && (string.trim().length() > 0)) {
      returnValue = false;
    }
    return returnValue;
  }

  public static boolean isEmpty(char[] chars)
  {
    if (chars == null) {
      return true;
    }
    return isEmpty(new String(chars));
  }

  public static boolean isNotEmpty(String string)
  {
    return (!(isEmpty(string)));
  }


}