/**
 * Copyright (c) 2023, Collins Aerospace.
 * Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
 * including any software or models in source or binary form, as well as any drawings, specifications, 
 * and documentation (collectively "the Data"), to deal in the Data without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Data.
 * 
 * THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 * 
 * Generated by Xtext version 2.25.0.
 */
package com.collins.trustedmethods.matrics.soar.soar.util;

import com.collins.trustedmethods.matrics.soar.soar.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.collins.trustedmethods.matrics.soar.soar.SoarPackage
 * @generated
 */
public class SoarAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SoarPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoarAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SoarPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SoarSwitch<Adapter> modelSwitch =
    new SoarSwitch<Adapter>()
    {
      @Override
      public Adapter caseSoarAnnexLibrary(SoarAnnexLibrary object)
      {
        return createSoarAnnexLibraryAdapter();
      }
      @Override
      public Adapter caseSoarAnnexSubclause(SoarAnnexSubclause object)
      {
        return createSoarAnnexSubclauseAdapter();
      }
      @Override
      public Adapter caseSoarProduction(SoarProduction object)
      {
        return createSoarProductionAdapter();
      }
      @Override
      public Adapter caseStateImpCondition(StateImpCondition object)
      {
        return createStateImpConditionAdapter();
      }
      @Override
      public Adapter caseAttrValueTest(AttrValueTest object)
      {
        return createAttrValueTestAdapter();
      }
      @Override
      public Adapter caseConditionExpr(ConditionExpr object)
      {
        return createConditionExprAdapter();
      }
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseActionSideExpr(ActionSideExpr object)
      {
        return createActionSideExprAdapter();
      }
      @Override
      public Adapter caseStateImpCond(StateImpCond object)
      {
        return createStateImpCondAdapter();
      }
      @Override
      public Adapter caseBinaryExpr(BinaryExpr object)
      {
        return createBinaryExprAdapter();
      }
      @Override
      public Adapter caseUnaryExpr(UnaryExpr object)
      {
        return createUnaryExprAdapter();
      }
      @Override
      public Adapter caseConjunctTestExpr(ConjunctTestExpr object)
      {
        return createConjunctTestExprAdapter();
      }
      @Override
      public Adapter caseMultiValTestExpr(MultiValTestExpr object)
      {
        return createMultiValTestExprAdapter();
      }
      @Override
      public Adapter caseDisjunctTestExpr(DisjunctTestExpr object)
      {
        return createDisjunctTestExprAdapter();
      }
      @Override
      public Adapter caseSymConstExpr(SymConstExpr object)
      {
        return createSymConstExprAdapter();
      }
      @Override
      public Adapter caseConstStringExpr(ConstStringExpr object)
      {
        return createConstStringExprAdapter();
      }
      @Override
      public Adapter caseStringExpr(StringExpr object)
      {
        return createStringExprAdapter();
      }
      @Override
      public Adapter casePrefSpecifierExpr(PrefSpecifierExpr object)
      {
        return createPrefSpecifierExprAdapter();
      }
      @Override
      public Adapter caseCrlfExpr(CrlfExpr object)
      {
        return createCrlfExprAdapter();
      }
      @Override
      public Adapter caseCommaExpr(CommaExpr object)
      {
        return createCommaExprAdapter();
      }
      @Override
      public Adapter caseParenExpr(ParenExpr object)
      {
        return createParenExprAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseAnnexLibrary(AnnexLibrary object)
      {
        return createAnnexLibraryAdapter();
      }
      @Override
      public Adapter caseModalElement(ModalElement object)
      {
        return createModalElementAdapter();
      }
      @Override
      public Adapter caseAnnexSubclause(AnnexSubclause object)
      {
        return createAnnexSubclauseAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarAnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarAnnexLibrary
   * @generated
   */
  public Adapter createSoarAnnexLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause
   * @generated
   */
  public Adapter createSoarAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SoarProduction <em>Production</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SoarProduction
   * @generated
   */
  public Adapter createSoarProductionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.StateImpCondition <em>State Imp Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.StateImpCondition
   * @generated
   */
  public Adapter createStateImpConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.AttrValueTest <em>Attr Value Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.AttrValueTest
   * @generated
   */
  public Adapter createAttrValueTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ConditionExpr <em>Condition Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ConditionExpr
   * @generated
   */
  public Adapter createConditionExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.Expr
   * @generated
   */
  public Adapter createExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ActionSideExpr <em>Action Side Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ActionSideExpr
   * @generated
   */
  public Adapter createActionSideExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.StateImpCond <em>State Imp Cond</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.StateImpCond
   * @generated
   */
  public Adapter createStateImpCondAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.BinaryExpr
   * @generated
   */
  public Adapter createBinaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.UnaryExpr
   * @generated
   */
  public Adapter createUnaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ConjunctTestExpr <em>Conjunct Test Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ConjunctTestExpr
   * @generated
   */
  public Adapter createConjunctTestExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.MultiValTestExpr <em>Multi Val Test Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.MultiValTestExpr
   * @generated
   */
  public Adapter createMultiValTestExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.DisjunctTestExpr <em>Disjunct Test Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.DisjunctTestExpr
   * @generated
   */
  public Adapter createDisjunctTestExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.SymConstExpr <em>Sym Const Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.SymConstExpr
   * @generated
   */
  public Adapter createSymConstExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ConstStringExpr <em>Const String Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ConstStringExpr
   * @generated
   */
  public Adapter createConstStringExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.StringExpr <em>String Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.StringExpr
   * @generated
   */
  public Adapter createStringExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.PrefSpecifierExpr <em>Pref Specifier Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.PrefSpecifierExpr
   * @generated
   */
  public Adapter createPrefSpecifierExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.CrlfExpr <em>Crlf Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.CrlfExpr
   * @generated
   */
  public Adapter createCrlfExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.CommaExpr <em>Comma Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.CommaExpr
   * @generated
   */
  public Adapter createCommaExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.collins.trustedmethods.matrics.soar.soar.ParenExpr <em>Paren Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.collins.trustedmethods.matrics.soar.soar.ParenExpr
   * @generated
   */
  public Adapter createParenExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexLibrary
   * @generated
   */
  public Adapter createAnnexLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ModalElement
   * @generated
   */
  public Adapter createModalElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexSubclause
   * @generated
   */
  public Adapter createAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SoarAdapterFactory
